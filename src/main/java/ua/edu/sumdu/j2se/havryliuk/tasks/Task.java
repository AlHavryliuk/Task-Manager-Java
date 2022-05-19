package ua.edu.sumdu.j2se.havryliuk.tasks;



public class Task {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeated;



    /*Конструктор Task(String title, int time), неактивної задачі з відсутністю інтервалу повторення */

    public Task(String title, int time) {
        this.title = title;
        this.time = time;
        repeated = false;
        active = false;


    }
    /*Конструктор Task(... , ... , ... , ...), неактивної задачі яка повторюється і має початок і кінець */

    public Task(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        repeated = true;
        active =false;

    }

    /* Методи для зчитування та встановлення назви задачі .*/

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

     /*  Методи для зчитування та встановлення стану активності задачі. */

    public boolean isActive() {

        return active;
    }

    public void setActive(boolean active) {

        this.active = active;
    }

    /*Методи для зчитування та зміни часу виконання для задач, що НЕ ПОВТОРЮЄТЬСЯ :*/

    public int getTime() {
        if (repeated) {
            return start;
        }
        return time;
    }

    public void setTime(int time) {
        if (repeated) {
            repeated = false;
        }
        this.time = time;
    }

    /*Методи для зчитування та зміни часу виконання для задач, що ПОВТОРЮЄТЬСЯ :*/

    public int getStartTime() {
        if (repeated) {
            return start;
        }
        return time;
    }

    public int getEndTime() {
        if (repeated) {
            return end;
        }
        return time;
    }

    public int getRepeatInterval() {
        if (repeated) {
            return interval;
        }
        return 0;
    }

    public void setTime(int start, int end, int interval) {
        if (!repeated) {
            repeated = true;
        }
        this.start = start;
        this.end = end;
        this.interval = interval;
    }
    public boolean isRepeated() {

        return repeated;
    }
    /* Перевірка часу наступного виконання задачі :*/
    
    public int nextTimeAfter(int current) {
        if (current < getStartTime() && isActive() && isRepeated()) {
            return getStartTime();
        } else if (current < getTime() && isActive() && !isRepeated()) {
            return getTime();
        } else if (isActive() && isRepeated() && current >= getStartTime() && current <= getEndTime()) {
            if (nextRepeat(current) == current){
            return nextRepeat(current) + interval;}{
                return  nextRepeat(current);
            }
        } return -1;
    }

    /* Допоміжний метод, що містить цикл неохідний для повернення конкретного моменту часу для задачі,
     яка має інтервал повторення :*/
    public  int nextRepeat (int current) {
        int i;
        for (i = this.start; i < this.end; i += this.interval) {
            if (i >= current) {
                break;
            }
        }
        if (i<=end) {
            return i;
        }else return -1;

    }
}










