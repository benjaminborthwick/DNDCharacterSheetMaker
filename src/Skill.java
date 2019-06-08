
public class Skill {
    int index;
    String skillName;
    int Proficiency;
    int skillModifier;
    public Skill(int index, String skillName, int Proficiency, int skillModifier) {
        this.index = index;
        this.skillName = skillName;
        this.Proficiency = Proficiency;
        this.skillModifier = skillModifier+Proficiency;
    }
}