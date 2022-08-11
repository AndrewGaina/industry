package industry;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	    InputData.init();
        InputData.normalize();
        var list = combineIndustry(InputData.companiesIndeed, InputData.companiesYahoo);
        for(Company c : list){
            System.out.println(c);
        }
    }

    //В данной функции происходит простая итерация двух списков содержащие объекты типа Company и добавление их в третий, "очищенный" список - processedData.
    //Для повышения скорости оба входных списка сортируются по лексиграфическому порядку, и с каждым удачным совпадением имён компаний между двумя списками, объекты удаляются.
    //Элементы первого списка будут сравниваться с элементами второго списка. Ссылки на них будут храниться в company_1 и company_2
    //Учитывая то, что списки отсортированы по алфавиту, в качестве первой проверки можем сравнить первые буквы company_1 и company_2
    //Со второй проверки смотрим полные совпадения, содержится ли имя компании 1 в имени компании 2, или наоборот. (Например, имя Alphabet содержится в Alphabet, Inc.)
    //Дальше создаём объект для хранения в третий список. Имя фактически можно взять откуда угодно, лично я решил брать из второго списка.
    //Индустрии в случае несовпадения объединяется в одну строку, отделённые точкой с запятой.
    //Объект попадает внутрь третьего списка, company_1 и company_2 удаляются из соответствующих списков.
    //При окончании циклов идёт проверка на то, если списки-аргументы пусты. Если в них что-то осталось, оно в неизменённом виде попадает в третий список.
    //processedData сортируется по алфавиту и возвращается как ответ, в main выводим содержимое в консоль
    public static List<Company> combineIndustry(List<Company> arr1, List<Company> arr2){

        List<Company> processedData = new ArrayList<>();
        Comparator<Company> comparator = (c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName());
        arr1.sort(comparator);
        arr2.sort(comparator);

        for (Iterator<Company> it_1 = arr1.iterator(); it_1.hasNext();){
            Company company_1 = it_1.next();
            String name_1 = company_1.getName();
            String firstC = company_1.getName().substring(0,1);
            for (Iterator<Company> it_2 = arr2.iterator(); it_2.hasNext();){
                Company company_2 = it_2.next();
                String name_2 = company_2.getName();
                if (name_2.startsWith(firstC)){
                    if (name_2.contains(name_1) || name_1.contains(name_2)){
                        String industry_1 = company_1.getIndustry();
                        String industry_2 = company_2.getIndustry();
                        String industry_3 = industry_1.equals(industry_2) ? industry_1 : industry_2 + "; " + industry_1;
                        Company processedCompany = new Company(name_2, industry_3);
                        processedData.add(processedCompany);
                        it_1.remove();
                        it_2.remove();
                        break;
                    }
                }
            }
        }
        if (!arr1.isEmpty()){
            processedData.addAll(arr1);
        }
        if (!arr2.isEmpty()){
            processedData.addAll(arr2);
        }
        processedData.sort(comparator);
        return processedData;
    }
}