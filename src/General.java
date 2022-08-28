import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class General {
    public static void main(String[] args) {
        Programmist programmist1 = new Programmist(ProgrammingLanguage.JAVA,"Ivanov",2100,true);
        Programmist programmist2 = new Programmist(ProgrammingLanguage.PYTHON,"Petrov",1500,true);
        Programmist programmist3 = new Programmist(ProgrammingLanguage.JAVA_SCRIPT,"Sidorov",1800,false);
        List<Programmist> programmists = new ArrayList<>();
        programmists.add(programmist1);
        programmists.add(programmist2);
        programmists.add(programmist3);

        int maxSalary = programmists.stream().
                collect(Collectors.summarizingInt(p -> p.getSalary())).getMax();
        System.out.println("Максимальное значение зарплаты равно " + maxSalary);
//        2й вариант нахождения максимального
        OptionalInt maxSalary2 = programmists.stream().mapToInt((s) -> s.getSalary()).max();


        int minSalary = programmists.stream().
                collect(Collectors.summarizingInt(p -> p.getSalary())).getMin();
        System.out.println("Минимальное значение зарплаты равно " + minSalary);
//        2й вариант нахождения минимального
        OptionalInt minSalary2 = programmists.stream().mapToInt((s) -> s.getSalary()).min();


        double avgSalary = programmists.stream().
                collect(Collectors.summarizingInt(p -> p.getSalary())).getAverage();
        System.out.println("Среднее значение зарплаты равно " + avgSalary);
//        2й вариант нахождения среднего арифметического
        double savgSalary2 = programmists.stream().
                collect(Collectors.averagingInt(x ->x.getSalary()));
//        3й вариант нахождения среднего арифметического
        OptionalDouble savgSalary3 = programmists.stream()
                .mapToDouble((s) -> s.getSalary()).average();


        int countProgrammists = (int) programmists.stream().
                collect(Collectors.summarizingInt(p -> p.getSalary())).getCount();
//        2й вариант нахождения количества
        int countProgrammists2 = (int) programmists.stream().mapToInt((s) -> s.getSalary()).count();
        System.out.println("Количество программистов равно " + countProgrammists);


        System.out.println("Список фио программистов, работающих на удаленке ");
        programmists.stream()
                .filter(x -> x.isDistantWork() == true)
                .forEach(x -> System.out.println(x.getFio()));

      /*
//      2 вариант (можно вместо partitioningBy - groupingBy)
      Map<Boolean, List<Programmist>> listIsDistantWork = programmists.stream().collect(Collectors.partitioningBy(x -> x.isDistantWork() == true));
        for (Map.Entry x : listIsDistantWork.entrySet()) {
            if (x.getKey().equals(true)) {
                System.out.println(x.getValue());
            }
        }
        */

        System.out.println("Количество программистов Java равно " +
        programmists.stream()
                .filter(x -> x.getLanguage() == ProgrammingLanguage.JAVA)
                .mapToInt((s) -> s.getSalary()).count());

        System.out.println("Список фио программистов Python, работающих на удаленке ");
        programmists.stream()
                .filter(x -> x.getLanguage() == ProgrammingLanguage.PYTHON)
                .filter(x -> x.isDistantWork() == true)
                .forEach(x -> System.out.println(x.getFio()));

        System.out.println("Самая большая зарпалата среди программистов JavaScript равна " +
        programmists.stream()
                .filter(x -> x.getLanguage() == ProgrammingLanguage.JAVA_SCRIPT)
                .mapToInt((s) -> s.getSalary()).max());


    }
}
