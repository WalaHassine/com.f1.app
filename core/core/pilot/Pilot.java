package core.pilot;

public class Pilot {
    private String name;
    private String nationality;
    private int skill;      
    private int experience; 

    public Pilot(String name, String nationality, int skill, int experience) {
        this.name = name;
        this.nationality = nationality;
        this.skill = skill;
        this.experience = experience;
    }

    public String getName() { return name; }
    public String getNationality() { return nationality; }
    public int getSkill() { return skill; }
    public int getExperience() { return experience; }

    @Override
    public String toString() {
        return name + " (" + nationality + ") skill=" + skill + ", exp=" + experience;
    }
}
