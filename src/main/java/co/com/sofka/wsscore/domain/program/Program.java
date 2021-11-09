package co.com.sofka.wsscore.domain.program;

import co.com.sofka.wsscore.domain.generic.AggregateRoot;
import co.com.sofka.wsscore.domain.generic.DomainEvent;
import co.com.sofka.wsscore.domain.program.event.CourseAssigned;
import co.com.sofka.wsscore.domain.program.event.ProgramCreated;
import co.com.sofka.wsscore.domain.program.event.ScoreAssigned;

import java.util.*;


public class Program extends AggregateRoot  {
    protected Map<String, Course> courses;
    protected Map<String, Score> scores;
    protected String name;

    public Program(String programId, String name){
        super(programId);
        System.out.println("domain 13");
        subscribe(new ProgramEventChange(this));
        appendChange(new ProgramCreated(name)).apply();
    }


    public void addCourse(String courseId, String name, List<String> categories){
        System.out.println("domain 14 ");
        appendChange(new CourseAssigned(courseId, name, categories)).apply();
    }

    public void assignScore(String user, String courseId, String category, String value, Date date){
        System.out.println("domain 15");
        appendChange(new ScoreAssigned(user, courseId, category, value, date)).apply();
    }


    private Program(String id){
        super(id);
        subscribe(new ProgramEventChange(this));
    }


    public static Program from(String id, List<DomainEvent> events){
        System.out.println("domain 17 "+events);
        var program = new Program(id);
        events.forEach(program::applyEvent);
        return program;
    }

    public String name() {
        return name;
    }

    public Course getCoursesById(String courseId) {
        System.out.println("domain 18 "+courseId);
        return courses.get(courseId);
    }

    public Score getScoreByCourseIdAndCategoryAndUser(String courseId, String category, String user){
        System.out.println("domain 19 ");
        return this.scores.get(courseId+category+user);
    }

    public Map<String, Score> scores() {
        System.out.println("domain 20");
        return scores;
    }
}