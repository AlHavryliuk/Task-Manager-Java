package ua.edu.sumdu.j2se.havryliuk.tasks;

import com.sun.source.tree.NewArrayTree;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Tasks {

    public static Iterable<Task> incoming(Iterable<Task> tasks, LocalDateTime start, LocalDateTime end) {
        return streamOf(tasks).filter((task -> task != null && (task.nextTimeAfter(start) != null) &&
                (task.nextTimeAfter(start).isBefore(end)) | task.nextTimeAfter(start).isEqual(end)))
                .collect(Collectors.toList());
    }


    private static Stream <Task> streamOf(Iterable<Task> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }


    public static SortedMap<LocalDateTime, Set <Task>> calendar (Iterable<Task> tasks,
              LocalDateTime start, LocalDateTime end) {

        SortedMap <LocalDateTime, Set<Task>> sortedMap = new TreeMap<>();

        Set <Task> set;
        LocalDateTime current;

        for (Task task : tasks) {
            current = task.nextTimeAfter(start);
            while (current != null && !current.isAfter(end)) {
                if (sortedMap.containsKey(current)) {
                    sortedMap.get(current).add(task);
                } else {
                    set = new HashSet<>();
                    set.add(task);
                    sortedMap.put(current, set);
                }
                current = task.nextTimeAfter(current);
            }
        }
        return sortedMap;
    }
}
