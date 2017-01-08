package age;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jola on 2016-12-29.
 */
public class Age {
    @Test
    public void listStatus() {
        List<Person> people = new ArrayList<Person>();
        people.add(new Person(10));
        people.add(new Person(17));
        people.add(new Person(18));
        people.add(new Person(45));
        people.add(new Person(66));
        people.add(new Person(67));
        people.add(new Person(120));

        List<Person> juniors = getJuniors(people);
        for (Person person : juniors) {

            Assertions.assertThat(person.getAge()).isLessThan(18);
        }

        List<Person> working = getWorking(people);
        for (Person person : working) {

            Assertions.assertThat(person.getAge()).isBetween(18, 67);
        }
        List<Person> seniors = getSeniors(people);
        for (Person person : seniors) {

            Assertions.assertThat(person.getAge()).isGreaterThan(67);
        }
    }

    private List<Person> getSeniors(List<Person> people) {
        List<Person> seniorsList;
        seniorsList = new ArrayList<Person>();

        for (Person person : people) {
            if (person.getAge() > 67) {
                seniorsList.add(person);
            }
        }
        return seniorsList;
    }

    private List<Person> getJuniors(List<Person> people) {
        List<Person> juniorList;
        juniorList = new ArrayList<Person>();
        for (Person person : people) {

            if (person.getAge() < 18) {
                juniorList.add(person);
            }
        }
        return juniorList;
    }

    private List<Person> getWorking(List<Person> people) {

        List<Person> workingList;
        workingList = new ArrayList<Person>();
        int age;

        for (Person person : people) {
            age = person.getAge();
            if (age >= 18 && age <= 67) {
                workingList.add(person);
            }
        }

        return workingList;
    }

}