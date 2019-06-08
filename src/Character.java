
public class Character {
	String characterClass;
	String characterRace;
	String characterGender;
	String characterName;
	int[] characterStats;
	int[] characterModifiers;
	//String[] characterBackground;
	//int[] characterSkillProficiencies;
	//int[] characterSkills;
	//int[] characterSavingThrows;
	public Character(String characterClass, String characterRace, String characterGender, String characterName, int[] characterStats, int[] characterModifiers) {
		this.characterClass = characterClass;
		this.characterRace = characterRace;
		this.characterGender = characterGender;
		this.characterName = characterName;
		this.characterStats = characterStats;
		this.characterModifiers = characterModifiers;
	}

}
