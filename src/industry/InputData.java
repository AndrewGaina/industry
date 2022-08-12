package industry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//Быстро созданный мною класс без особого нюанса чтобы спрятать в основном ненужную информацию вроде входных данных и
//нормализации названий компаний для облегчения поиска за счёт простых replace'ов.
//Не использовал regex из соображений производительности.
public class InputData {

    public static List<Company> companiesIndeed = new ArrayList<>();
    public static List<Company> companiesYahoo = new ArrayList<>();

    public static void normalize(){
        companiesYahoo = companiesYahoo.stream()
                .peek(company -> {
                    String replaced = company.getName()
                            .replace("The ", "")
                            .replace(",","")
                            .replace(".", "")
                            .replace("Limited","")
                            .replace("inc", "")
                            .replace("Inc", "")
                            .replace("plc","")
                            .replace("Ltd,","")
                            .replace("ltd", "")
                            .replace("A/S","")
                            .replace(")","")
                            .replace("(","")
                            .trim();
                    company.setName(replaced);
                }).collect(Collectors.toList());
        companiesIndeed = companiesIndeed.stream()
                .peek(company -> {
                    String replaced = company.getName()
                            .replace("The ", "")
                            .replace(",","")
                            .replace(".", "")
                            .replace("Limited","")
                            .replace("inc", "")
                            .replace("Inc", "")
                            .replace("plc","")
                            .replace("Ltd,","")
                            .replace("ltd", "")
                            .replace("A/S","")
                            .replace(")","")
                            .replace("(","")
                            .trim();
                    company.setName(replaced);
                }).collect(Collectors.toList());
    }

    public static void init(){
        companiesYahoo.add(new Company("Netflix, inc.", "Entertainment")); //1
        companiesYahoo.add(new Company("Alphabet inc.", "Internet Content & Information")); //2
        companiesYahoo.add(new Company("BHP Group Limited", "Other Industrial Metals & Mining")); //3
        companiesYahoo.add(new Company("Ecolab Inc.", "Specialty Chemicals")); //4
        companiesYahoo.add(new Company("Apple Inc.", "Consumer Electronics")); //5
        companiesYahoo.add(new Company("Activision Blizzard, Inc.", "Electronic Gaming & Multimedia")); //6
        companiesYahoo.add(new Company("NVIDIA Corporation", "Semiconductors")); //7
        companiesYahoo.add(new Company("Applied Materials, Inc.", "Semiconductor Equipment & Materials")); //8
        companiesYahoo.add(new Company("Visa Inc.", "Credit Services")); //9
        companiesYahoo.add(new Company("The Coca-Cola Company", "Beverages—Non-Alcoholic")); //10
        companiesYahoo.add((new Company("Wells Fargo & Company","Banks—Diversified")));
        companiesYahoo.add((new Company("NIKE, Inc.","Footwear & Accessories")));
        companiesYahoo.add((new Company("Sea Limited","Internet Retail")));
        companiesYahoo.add((new Company("Tesla, Inc.","Auto Manufacturers")));
        companiesYahoo.add((new Company("Chipotle Mexican Grill, Inc."," Restaurants")));
        companiesYahoo.add((new Company("Allstate Insurance, Inc.","Insurance—Property & Casualty")));
        companiesYahoo.add((new Company("Barrick Gold Corporation","Gold")));
        companiesYahoo.add((new Company("United States Steel Corporation","Steel")));
        companiesYahoo.add((new Company("Abbot Laboratories","Medical Devices")));
        companiesYahoo.add((new Company("Novo Nordisk A/S","Biotechnology")));
        companiesYahoo.add((new Company("Johnson & Johnson","Drug Manufacturers—General")));
        companiesYahoo.add((new Company("Chevron Corporation","Oil & Gas Integrated")));
        companiesYahoo.add((new Company("Pioneer Natural Resources Company","Oil & Gas E&P")));
        companiesYahoo.add((new Company("Becton, Dickinson and Company","Medical Instruments & Supplies")));
        companiesYahoo.add((new Company("Union Pacific Corporation","Railroads")));
        companiesYahoo.add((new Company("Waste Management, Inc.","Waste Management")));
        companiesYahoo.add((new Company("Nutrien Ltd.","Agricultural Inputs")));
        companiesYahoo.add((new Company("The Procter & Gamble Company","Household & Personal Products")));
        companiesYahoo.add((new Company("Morgan Stanley","Capital Markets")));
        companiesYahoo.add((new Company("Duke Energy Corporation","Utilities—Regulated Electric")));
        companiesYahoo.add((new Company("American Water Works Company, Inc.","Utilities—Regulated Water")));
        companiesYahoo.add((new Company("Oracle Corporation","Software—Infrastructure")));
        companiesYahoo.add((new Company("Las Vegas Sands Corp.","Resorts & Casinos")));
        companiesYahoo.add((new Company("The Home Depot, Inc.","Home Improvement Retail")));
        companiesYahoo.add((new Company("Berkshire Hathaway Inc.","Insurance—Diversified")));
        companiesYahoo.add((new Company("Simon Property Group, Inc.","REIT—Retail")));
        companiesYahoo.add((new Company("Extra Space Storage Inc.","REIT—Industrial")));
        companiesYahoo.add((new Company("Uber Technologies, Inc.","Software—Application")));
        companiesYahoo.add((new Company("Public Storage","REIT—Industrial")));
        companiesYahoo.add((new Company("Vulcan Materials Company","Building Materials")));
        companiesYahoo.add((new Company("CVS Health Corporation","Healthcare Plans")));
        companiesYahoo.add((new Company("Sempra","Utilities—Diversified")));
        companiesYahoo.add((new Company("Ross Stores, Inc.","Apparel Retail")));
        companiesYahoo.add((new Company("Sealed Air Corporation","Packaging & Containers")));
        companiesYahoo.add((new Company("Paramount Global","Entertainment")));
        companiesYahoo.add((new Company("The Hershey Company","Confectioners")));
        companiesYahoo.add((new Company("British American Tobacco p.l.c.","Tobacco")));
        companiesYahoo.add((new Company("Walmart Inc.","Discount Stores")));
        companiesYahoo.add((new Company("General Mills, Inc.","Packaged Foods")));
        companiesYahoo.add((new Company("3M Company","Conglomerates")));
        companiesYahoo.add(new Company("foo", "bar"));

        Collections.shuffle(companiesYahoo);

        companiesIndeed.add(new Company("Netflix", "Media & Communication")); //1
        companiesIndeed.add(new Company("Alphabet", "Information Technology")); //2
        companiesIndeed.add(new Company("BHP", "Energy, Mining & Utilities")); //3
        companiesIndeed.add(new Company("Ecolab", "Manufacturing")); //4
        companiesIndeed.add(new Company("Apple", "Information Technology")); //5
        companiesIndeed.add(new Company("Activision Blizzard", "Culture & Entertainment")); //6
        companiesIndeed.add(new Company("NVIDIA", "Information Technology")); //7
        companiesIndeed.add(new Company("Applied Materials", "Electronics Manufacturing")); //8
        companiesIndeed.add(new Company("Visa", "Financial Services")); //9
        companiesIndeed.add(new Company("The Coca-Cola Company", "Food & Beverage Manufacturing")); //10
        companiesIndeed.add((new Company("Wells Fargo","Financial Services")));
        companiesIndeed.add((new Company("NIKE","Retail & Wholesale")));
        companiesIndeed.add((new Company("Sea, Ltd.","Information Technology")));
        companiesIndeed.add((new Company("Tesla","Manufacturing")));
        companiesIndeed.add((new Company("Chipotle Mexican Grill","Restaurants & Food Service")));
        companiesIndeed.add((new Company("Allstate Insurance","Insurance")));
        companiesIndeed.add((new Company("Barrick Gold Corporation","Energy, Mining & Utilities")));
        companiesIndeed.add((new Company("United States Steel","Manufacturing")));
        companiesIndeed.add((new Company("Abbot","Healthcare")));
        companiesIndeed.add((new Company("Novo Nordisk","Pharmaceutical & Biotechnology")));
        companiesIndeed.add((new Company("Johnson & Johnson","Healthcare")));
        companiesIndeed.add((new Company("Chevron","Energy, Mining & Utilities")));
        companiesIndeed.add((new Company("Pioneer Natural Resources Company","Energy, Mining & Utilities")));
        companiesIndeed.add((new Company("Becton Dickinson","Healthcare")));
        companiesIndeed.add((new Company("Union Pacific","Transportation & Logistics")));
        companiesIndeed.add((new Company("Waste Management","Energy, Mining & Utilities")));
        companiesIndeed.add((new Company("Nutrien","Agriculture")));
        companiesIndeed.add((new Company("Procter & Gamble","Manufacturing")));
        companiesIndeed.add((new Company("Morgan Stanley","Financial Services")));
        companiesIndeed.add((new Company("Duke Energy","Energy, Mining & Utilities")));
        companiesIndeed.add((new Company("American Water","Energy, Mining & Utilities")));
        companiesIndeed.add((new Company("Oracle","Information Technology")));
        companiesIndeed.add((new Company("Las Vegas Sands Corp.","Resorts & Casinos")));
        companiesIndeed.add((new Company("The Home Depot","Retail & Wholesale")));
        companiesIndeed.add((new Company("Berkshire Hathaway","Insurance")));
        companiesIndeed.add((new Company("Extra Space Storage","Real Estate")));
        companiesIndeed.add((new Company("Uber Technologies","Information Technology")));
        companiesIndeed.add((new Company("Simon Property Group","Real Estate")));
        companiesIndeed.add((new Company("Vulcan Materials Company","Mining & Metals")));
        companiesIndeed.add((new Company("Public Storage","Retail & Wholesale")));
        companiesIndeed.add((new Company("CVS Health","Healthcare")));
        companiesIndeed.add((new Company("Sempra","Energy, Mining & Utilities")));
        companiesIndeed.add((new Company("Ross Stores","Retail & Wholesale")));
        companiesIndeed.add((new Company("Sealed Air","Manufacturing")));
        companiesIndeed.add((new Company("Paramount Global","Media & Communication")));
        companiesIndeed.add((new Company("The Hershey Company","Manufacturing")));
        companiesIndeed.add((new Company("British American Tobacco","Manufacturing")));
        companiesIndeed.add((new Company("Walmart","Retail & Wholesale")));
        companiesIndeed.add((new Company("General Mills","Manufacturing")));
        companiesIndeed.add((new Company("3M","Manufacturing")));
        companiesIndeed.add(new Company("bar", "foo"));

        Collections.shuffle(companiesIndeed);

    }
}
