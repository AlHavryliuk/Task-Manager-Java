package ua.edu.sumdu.j2se.havryliuk.tasks;


import com.google.gson.*;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TaskIO {


    public static void write (AbstractTaskList tasks, OutputStream out) {

        try (ObjectOutputStream oos = new ObjectOutputStream(out)) {
            oos.writeInt(tasks.size());
            for (Task task : tasks) {
                oos.writeInt(task.getTitle().length());
                oos.writeChars(task.getTitle());
                oos.writeBoolean(task.isActive());
                oos.writeInt(task.getRepeatInterval());

                if (task.isRepeated()) {
                    oos.writeObject(task.getStartTime());
                    oos.writeObject(task.getEndTime());
                } else {
                    oos.writeObject(task.getTime());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public static void read (AbstractTaskList tasks, InputStream in) {

        try (ObjectInputStream ois = new ObjectInputStream(in)) {
            int size = ois.readInt();
            for (int i = 0; i < size; i++) {
                int titleSize = ois.readInt();
                char[] chars = new char[titleSize];

                for (int j = 0; j < titleSize; j++) {
                    chars[j] = ois.readChar();}

                boolean active = ois.readBoolean();
                int interval = ois.readInt();
                LocalDateTime tempTime = (LocalDateTime) ois.readObject();

                Task task;
                String title = String.valueOf(chars);
                if (interval == 0)
                    task = new Task(title, tempTime);
                else {
                    LocalDateTime endTime = (LocalDateTime) ois.readObject();
                    task = new Task(title, tempTime, endTime, interval);
                }
                task.setActive(active);
                tasks.add(task);
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeBinary (AbstractTaskList tasks, File file){
        try (BufferedOutputStream bos = new BufferedOutputStream((new FileOutputStream(file)))){
            write(tasks, bos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readBinary (AbstractTaskList tasks, File file){
        try (BufferedInputStream bis = new BufferedInputStream((new FileInputStream(file)))){
            read(tasks, bis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void write(AbstractTaskList tasks, Writer out) {


        try (JsonWriter jsonWriter = new JsonWriter(out)) {
            jsonWriter.beginObject();
            jsonWriter.name("Task list");
            jsonWriter.beginArray();
            for (Task task : tasks) {
                jsonWriter.beginObject();
                jsonWriter.name("title").value(task.getTitle());
                jsonWriter.name("activity").value(task.isActive());
                jsonWriter.name("interval").value(task.getRepeatInterval());
                if (task.isRepeated()) {
                    jsonWriter.name("start time").value(dtf.format(task.getStartTime()));
                    jsonWriter.name("end time").value(dtf.format(task.getEndTime()));
                } else {
                    jsonWriter.name("time").value(dtf.format(task.getTime()));
                }
                jsonWriter.endObject();
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void read (AbstractTaskList tasks, Reader in) {


        Task task;
        JsonObject obj = JsonParser.parseReader(in).getAsJsonObject();
        JsonArray array;
        array = (JsonArray) obj.get("Task list");
        for (JsonElement jsonElement : array) {
            JsonObject taskFromArray = (JsonObject) jsonElement;
            String title = (String.valueOf(taskFromArray.get("title"))).replace("\"", "");
            boolean active = (taskFromArray.get("activity")).getAsBoolean();
            int interval = (taskFromArray.get("interval")).getAsInt();
            if (interval != 0) {
                LocalDateTime startTime = LocalDateTime.parse(((taskFromArray.get("start time")).getAsString()), dtf);
                LocalDateTime endTime = LocalDateTime.parse(((taskFromArray.get("end time")).getAsString()), dtf);
                task = new Task(title, startTime, endTime, interval);
            } else {
                LocalDateTime time = LocalDateTime.parse(((taskFromArray.get("time")).getAsString()), dtf);
                task = new Task(title, time);
            }
            task.setActive(active);
            tasks.add(task);
        }
    }



    public static void writeText (AbstractTaskList tasks, File file) throws IOException {
        try (FileWriter fileWriter = new FileWriter(file)){
            write (tasks, fileWriter);
        }
    }

    public static void readText (AbstractTaskList tasks, File file) throws IOException {
        try (FileReader fileReader = new FileReader(file)) {
            read (tasks, fileReader);

        }
    }
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss");


}
