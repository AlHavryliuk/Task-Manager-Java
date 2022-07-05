    package ua.edu.sumdu.j2se.havryliuk.tasks;


    import java.io.Serializable;
    import java.time.LocalDateTime;



    public class Task implements Cloneable, Serializable {
        private String title;
        private LocalDateTime time;
        private LocalDateTime start;
        private LocalDateTime end;
        private int interval;
        private boolean active;
        private boolean repeated;



        /*Конструктор Task(String title, int time), неактивної задачі з відсутністю інтервалу повторення */

        public Task(String title, LocalDateTime time) throws IllegalArgumentException {

            this.title = title;
            if (title.isEmpty())
                throw new IllegalArgumentException("String is empty");
            this.time = time;
            if (this.time == null){
                throw new IllegalArgumentException();
            }
            repeated = false;
            active = false;

        }

        /*Конструктор Task(... , ... , ... , ...), неактивної задачі яка повторюється і має початок і кінець */

        public Task(String title, LocalDateTime start, LocalDateTime end, int interval) throws IllegalArgumentException {

            this.title = title;
            if (title.isEmpty())
                throw new IllegalArgumentException("String is empty");
            this.start = start;
            this.end = end;
            if (this.start == null || this.end == null){
                throw new IllegalArgumentException();
            }
            this.interval = interval;
            repeated = true;
            active =false;
        }

        /* Методи для зчитування та встановлення назви задачі.*/

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) throws IllegalArgumentException {
            if (title.isEmpty())
                throw new IllegalArgumentException("String is empty");
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

        public LocalDateTime getTime() {
            if (repeated) {
                return start;
            }
            return time;
        }

        public void setTime(LocalDateTime time) {
            if (repeated) {
                repeated = false;
            }
            this.time = time;
        }

        /*Методи для зчитування та зміни часу виконання для задач, що ПОВТОРЮЄТЬСЯ :*/

        public LocalDateTime getStartTime() {
            if (repeated) {
                return start;
            }
            return time;
        }

        public LocalDateTime getEndTime() {
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

        public void setTime(LocalDateTime start, LocalDateTime end, int interval) {
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

        public LocalDateTime nextTimeAfter(LocalDateTime current) {

            if (!isActive()){
                return null;
            } if (current.isBefore(getTime())) {
                return getTime();
            } else if (current.isEqual(getTime()) && !isRepeated()) {
                return null;
            } else if (current.isEqual(getStartTime())) {
                return getStartTime().plusSeconds(interval);
            } else if (current.isBefore(getStartTime())) {
                return getStartTime();
            } else if (current.isAfter(getStartTime())
                    && current.isBefore(getEndTime())) {
                return nextRepeat(current);
            }
            return null;
        }


        /* Допоміжний метод, що містить цикл необхідний для повернення конкретного моменту часу для задачі,
         яка має інтервал повторення :*/

        public LocalDateTime nextRepeat (LocalDateTime current) {

            LocalDateTime helpTime = getStartTime();
            LocalDateTime nextInter;
            for (LocalDateTime i = getStartTime() ; i.isBefore(getEndTime())  ; i = i.plusSeconds(interval)) {
                helpTime = i;
                nextInter = helpTime.plusSeconds(interval);
                if (i.equals(current)) {
                    return helpTime.plusSeconds(interval);
                }
                if (current.isEqual(getEndTime().minusSeconds(1))){
                    return helpTime.plusDays(1);
                }
                if (i.isBefore(current) && nextInter.isAfter(getEndTime())) {
                    return null;
                }
                if (i.isAfter(current)) {
                    return helpTime;
                }
            }
            return helpTime;
        }


        @Override
        public boolean equals(Object obj) {
            if(obj == null)
                return false;
            return ( this.title.equals(((Task) obj).title)
                    && this.time == ((Task) obj).time
                    && this.start == ((Task) obj).start
                    && this.end == ((Task) obj).end
                    && this.interval == ((Task) obj).interval
                    && this.active == ((Task) obj).active
                    && this.repeated == ((Task) obj).repeated
            );
        }

        @Override
        public int hashCode() {
            return this.getTitle().hashCode()*11;
        }

        @Override
        public String toString() {
            if(!this.repeated) return " Task : " + this.getTitle() + "\n Time : " + getTime() + "\n";
            return " Task : " + this.getTitle() + "\n Start time : "
                    + getStartTime() + "\n end time : " + getEndTime() +
                    "\n interval: "+ getRepeatInterval() + "\n";
        }
        @Override
        public Task clone() throws CloneNotSupportedException {
            Task clone = (Task)super.clone();
            clone.title = this.title;
            clone.time = this.time;
            clone.start = this.start;
            clone.end = this.end;
            clone.interval = this.interval;
            clone.active = this.active;
            clone.repeated = this.repeated;
            return clone;
        }
    }