package ua.edu.sumdu.j2se.havryliuk.tasks;


public class UnusedAdapterOldVersion {
/*

    public static LocalDateTime adapter (String time) {

        String[] parts = time.split(" ");
        int mount =LocalDateTime.now().getMonthValue(); *//*= Integer.parseInt(parts[0]);*//*
        int day = Integer.parseInt(parts[0]);
        int hour = Integer.parseInt(parts[1]);
        int minutes = Integer.parseInt(parts[2]);


        if (day < LocalDateTime.now().getDayOfMonth()) {
            mount += 1;
            System.out.println(" Task moved to next month.\n ");
        }
        LocalDateTime parseDate = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hour, minutes, LocalDateTime.now().getSecond());

        return parseDate;
    }

    public static LocalDateTime adapterCalendar (String time) {

        String[] parts = time.split(" ");
        int mount =Integer.parseInt(parts[0]);; *//*= Integer.parseInt(parts[0]);*//*
        int day = Integer.parseInt(parts[1]);
        int hour = Integer.parseInt(parts[2]);
        int minutes = Integer.parseInt(parts[3]);

        LocalDateTime parseDate = LocalDateTime.of(LocalDateTime.now().getYear(), mount, day,
                hour, minutes, LocalDateTime.now().getSecond());

        return parseDate;
    }

    public static void adapterCalendarTime (String time) throws IOException {

        String[] logic = time.split(" ");

        int day = Integer.parseInt(logic[0]);
        if ((day <= 0 | day > 31)) {
            System.out.println(" Incorrectly format. Please, try again. ");
            calendar();
            return;
        }
        int hour = Integer.parseInt(logic[1]);
        if ((hour < 0 | hour > 23)) {
            System.out.println(" Incorrectly format. Please, try again. ");
            calendar();
            return;
        }
        int minutes = Integer.parseInt(logic[2]);
        if ((minutes < 0 | minutes > 59)) {
            System.out.println(" Incorrectly format. Please, try again. ");
            calendar();
        }
    }*/
}
