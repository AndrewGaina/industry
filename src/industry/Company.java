package industry;

import java.util.Objects;

//Стандартный POJO класс для хранения данных о компаний
public class Company {

    private String name;

    private String industry;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Company(String name, String industry) {
        this.name = name;
        this.industry = industry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company)) return false;
        Company that = (Company) o;
        return Objects.equals(name, that.name) && Objects.equals(industry, that.industry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, industry);
    }

    @Override
    public String toString() {
        return "Company {" + "name : '" + name + '\'' + ", industry : '" + industry + '\'' + '}';
    }
}
