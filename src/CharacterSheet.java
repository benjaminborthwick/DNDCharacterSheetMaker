import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Map;
import java.util.ArrayList;
public class CharacterSheet {
	static Character playerCharacter;
	static Skill acrobatics;
	static Skill animalHandling;
	static Skill arcana;
	static Skill athletics;
	static Skill deception;
	static Skill history;
	static Skill insight;
	static Skill intimidation;
	static Skill investigation;
	static Skill medicine;
	static Skill nature;
	static Skill perception;
	static Skill performance;
	static Skill persuasion;
	static Skill religion;
	static Skill sleightOfHand;
	static Skill stealth;
	static Skill survival;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		intro();
		String characterClass = characterClass();
		String characterRace = characterRace(characterClass);
		String characterGender = characterGender();
		String characterName = characterName(characterRace, characterGender);
		int[] characterStats = characterStats(characterRace, characterClass);
		int[] characterModifiers = characterModifiers(characterStats);
		String characterAlignment = characterAlignment(characterRace);
		String[] characterBackground = characterBackground();
		Skill[] characterSkills = characterSkills(characterModifiers, characterRace, characterClass, characterBackground[0]);
		for(int i = 0;i<17;i++){
			System.out.println(characterSkills[i].index + ", " + characterSkills[i].skillName + ", " + characterSkills[i].Proficiency + ", " + characterSkills[i].skillModifier);
		}
		//int[] characterSavingThrows = characterSavingThrows(characterStats, savingThrowProficiencies);
		playerCharacter = new Character(characterClass, characterRace, characterGender, characterName, characterStats, characterModifiers);
	} 
	public static void intro() {
		System.out.println("Welcome to my Dungeons and Dragons character Creator!");
		System.out.println("I will ask you for a variety of inputs and then give you your completed character sheet.");
		System.out.println("When I ask you a question, type the number that is on the line of the answer you would like to choose.");
	} public static String characterClass() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Alright, let's get started. First of all, which class would you like to be? \n1. Barbarian \n2. Bard\n3. Cleric\n4. Druid\n5. Fighter\n6. Monk\n7. Paladin\n8. Ranger\n9. Rogue\n10. Sorcerer\n11. Warlock\n12. Wizard");
		int characterClass = userInput.nextInt();
		String classChoice = "";
		switch(characterClass) {
		case 1:
			System.out.println("You picked Barbarian");
			classChoice = "Barbarian";
			break;
		case 2:
			System.out.println("You picked Bard");
			classChoice = "Bard";
			break;
		case 3:
			System.out.println("You picked Cleric");
			classChoice = "Cleric";
			break;
		case 4:
			System.out.println("You picked Druid");
			classChoice = "Druid";
			break;
		case 5:
			System.out.println("You picked Fighter");
			classChoice = "Fighter";
			break;
		case 6:
			System.out.println("You picked Monk");
			classChoice = "Monk";
			break;
		case 7:
			System.out.println("You picked Paladin");
			classChoice = "Paladin";
			break;
		case 8:
			System.out.println("You picked Ranger");
			classChoice = "Ranger";
			break;
		case 9:
			System.out.println("You picked Rogue");
			classChoice = "Rogue";
			break;
		case 10:
			System.out.println("You picked Sorcerer");
			classChoice = "Sorcerer";
			break;
		case 11:
			System.out.println("You picked Warlock");
			classChoice = "Warlock";
			break;
		case 12:
			System.out.println("You picked Wizard");
			classChoice = "Wizard";
			break;
		default:
			System.out.println("That wasn't an option. Your class will default to fighter.");
			classChoice = "Fighter";
			break;
		} 
		return classChoice;
	}
	public static String characterRace(String Class){
		System.out.println("Now you must choose a Race. Different races provide ability score bonuses \nto different stats.");
		String bestStat = "";
		String goodStat = "";
		Scanner userInput = new Scanner(System.in);
		switch(Class) {
		case "Barbarian":
			bestStat = "Strength";
			goodStat = "Constitution";
			break;
		case "Bard":
			bestStat = "Charisma";
			goodStat = "Dexterity";
			break;
		case "Cleric":
			bestStat = "Wisdom";
			goodStat = "Charisma";
			break;
		case "Druid":
			bestStat = "Wisdom";
			goodStat = "Intelligence";
			break;
		case "Fighter":
			bestStat = "Strength or Dexterity";
			goodStat = "Constitution";
			break;
		case "Monk":
			bestStat = "Dexterity";
			goodStat = "Wisdom";
			break;
		case "Paladin":
			bestStat = "Strength";
			goodStat = "Charisma";
			break;
		case "Ranger":
			bestStat = "Dexterity";
			goodStat = "Wisdom";
			break;
		case "Rogue":
			bestStat = "Dexterity";
			goodStat = "Charisma or Intelligence";
			break;
		case "Sorcerer":
			bestStat = "Charisma";
			goodStat = "Dexterity";
			break;
		case "Warlock":
			bestStat = "Charisma";
			goodStat = "Wisdom";
			break;
		case "Wizard":
			bestStat = "Intelligence";
			goodStat = "Dexterity";
			break;
		default:
			break;
		} System.out.println("For your class, the most important stat is " + bestStat + ".\nThe second most important stat is " + goodStat);
		System.out.println("Here are the races:\n1. Dwarf(+2 Constitution/+2 Strength or +1 Wisdom)\n2. Elf(Dexterity +2/Intelligence +1 or Wisdom +1 or Charisma +1)\n3. Halfling(Dexterity +2/Constitution +1 or Charisma +1)\n4. Human(+1 to all stats)\n5. Dragonborn(Strength +2/Charisma +1)\n6. Gnome(Intelligence +2/Dexterity +1 or Constitution +1)\n7. Half-elf(Charisma +2 and +1 to any two other stats of your choice)\n8. Half-orc(Strength +2/Constitution +1)\n9. Tiefling(Charisma +2/Intelligence +1)");
		int raceChoice = userInput.nextInt();
		String race;
		switch(raceChoice) {
		case 1:
			System.out.println("You chose Dwarf");
			race = "Dwarf";
			break;
		case 2:
			System.out.println("You chose Elf");
			race = "Elf";
			break;
		case 3:
			System.out.println("You chose Halfling");
			race = "Halfling";
			break;
		case 4:
			System.out.println("You chose Human");
			race = "Human";
			break;
		case 5:
			System.out.println("You chose Dragonborn");
			race = "Dragonborn";
			break;
		case 6:
			System.out.println("You chose Gnome");
			race = "Gnome";
			break;
		case 7:
			System.out.println("You chose Half-elf");
			race = "Half-elf";
			break;
		case 8:
			System.out.println("You chose Hald-orc");
			race = "Half-orc";
			break;
		case 9:
			System.out.println("You chose Tiefling");
			race = "Tiefling";
			break;
		default:
			System.out.println("That wasn't an option. Your race has defaulted to human");
			race = "Human";
			break;
		}
		return race;
	}
	public static String characterGender(){
		Scanner userInput = new Scanner(System.in);
		System.out.println("What gender is your character?\n1. Male\n2. Female\n3. Other");
		int characterGender = userInput.nextInt();
		String Gender;
		if(characterGender == 1){
			System.out.println("You picked male");
			Gender = "Male";
		} else if(characterGender == 2){
			System.out.println("You picked female");
			Gender = "Female";
		} else if(characterGender == 3){
			System.out.println("You picked other");
			Gender = "Other";
		} else{
			System.out.println("That wasn't an option. Your gender will default to other.");
			Gender = "Other";
		} return Gender;
	}
	public static String characterName(String Race, String Gender){
		Scanner userInput = new Scanner(System.in);
		System.out.println("Now you must choose a name for your character. \nIf you want a list of common names, type 'names' with no capitals.");
		if(Race.equals("Dragonborn")){
			System.out.println("For your race(Dragonborn) Clan names come before first names. Keep this in mind when choosing a name.");
		} else if(Race.equals("Gnome")) {
			System.out.println("Gnomes have 3 names:A first name, A clan name, and a nickname. In each category halflings \nrecieve all sorts of names from friends and family, and when dealing with non-gnomes \nthey choose the name in each category that is the most fun to say.");
		} else if(Race.equals("Half-elf")){
			System.out.println("Half-elves usually are named with either elven or human naming conventions. Often times \nHalf-elves in human society are named with Elvish naming conventions and Half-elves in \nElvish society are names with Human naming conventions. You should know \na good bit about Human naming conventions, so in the 'names' section I \nwill list Elvish names.");
		} else if(Race.equals("Half-orc")){
			System.out.println("Half-orcs have no clan names. In addition, Half-orcs are often given names appropriate to \nthe culture in which they were raised. For example, a human raised Half-orc might have \nhuman names instead.");
		} else if(Race.equals("Tiefling")){
			System.out.println("Tiefling names will be in one of three categories: names from the culture they grew up \nin, names derived from the Infernal language, and names that signify a virtue or other \nconcept that the tiefling will try to embody. Tieflings have no last names.");
		}
		String characterName = userInput.nextLine();
		if(characterName.equals("names")){
			switch(Race){
			case "Dwarf":
				if(Gender.equals("Male")){
					System.out.println("Male Names: Adrik, Alberich, Baern, Barendd, Brottor, Bruenor, Dain, Darrak, Delg, \nEberk, Einkil, Fargrim, Flint, Gardain, Harbek, Kildrak, Morgran, Orsik, Oskar, Rangrim, \nRurik, Taklinn, Thoradin, Thorin, Tordek, Traubon, Travok, Ulfgar, Veit, Vondal");
				} else if(Gender.equals("Female")){
					System.out.println("Female Names: Amber, Artin, Audhild, Bardryn, Dagnal, Diesa, Eldeth, Falkrunn, Finellen, \nGunnloda, Gurdis, Helja, Hlin, Kathra, Kristryd, Ilde, Liftrasa, Mardred, Riswynn, \nSannl, Torbera, Torgga, Vistra ");
				} else{
					System.out.println("Male Names: Adrik, Alberich, Baern, Barendd, Brottor, Bruenor, Dain, Darrak, Delg, \nEberk, Einkil, Fargrim, Flint, Gardain, Harbek, Kildrak, Morgran, Orsik, Oskar, Rangrim, \nRurik, Taklinn, Thoradin, Thorin, Tordek, Traubon, Travok, Ulfgar, Veit, Vondal");
					System.out.println("Female Names: Amber, Artin, Audhild, Bardryn, Dagnal, Diesa, Eldeth, Falkrunn, Finellen, \nGunnloda, Gurdis, Helja, Hlin, Kathra, Kristryd, Ilde, Liftrasa, Mardred, Riswynn, \nSannl, Torbera, Torgga, Vistra ");
				} System.out.println("Clan names:  Balderk, Battlehammer, Brawnanvil, Dankil, Fireforge, Frostbeard,\nGorunn, Holderhek, Ironfist, Loderr, Lutgehr, Rumnaheim, Strakeln, Torunn, Ungart");
				break;
			case "Elf":
				if(Gender.equals("Male")){
					System.out.println("Male Names: Adran, Aelar, Aramil, Arannis, Aust, Beiro, Berrian, Carric , Enialis, \nErdan, Erevan, Galinndan, Hadarai, Heian, Himo, Immeral, Ivellios, Laucian, Mindartis, \nPaelias, Peren, Quarion, Riardon, Rolen, Soveliss, Thamior, Tharivol, Theren, Varis");
				} else if(Gender.equals("Female")){
					System.out.println("Female Names: Adrie, Althaea, Anastrianna, Andraste, Antinua, Bethrynna, Birel, \nCaelynn, Drusilia, Enna, Felosial, Ielenia, Jelenneth, Keyleth, Leshanna, Lia, Meriele, \nMialee, Naivara, Quelenna, Quillathe, Sariel, Shanairra, Shava, Silaqui, Theirastra, \nThia, Vadania, Valanthe, Xanaphia ");
				} else{
					System.out.println("Male Names: Adran, Aelar, Aramil, Arannis, Aust, Beiro, Berrian, Carric , Enialis, \nErdan, Erevan, Galinndan, Hadarai, Heian, Himo, Immeral, Ivellios, Laucian, Mindartis, \nPaelias, Peren, Quarion, Riardon, Rolen, Soveliss, Thamior, Tharivol, Theren, Varis");
					System.out.println("Female Names: Adrie, Althaea, Anastrianna, Andraste, Antinua, Bethrynna, Birel, \nCaelynn, Drusilia, Enna, Felosial, Ielenia, Jelenneth, Keyleth, Leshanna, Lia, Meriele, \nMialee, Naivara, Quelenna, Quillathe, Sariel, Shanairra, Shava, Silaqui, Theirastra, \nThia, Vadania, Valanthe, Xanaphia ");
				} System.out.println("Family Names (Common Translations): Amakiir (Gemflower), Amastacia (Starflower), \nGalanodel (Moonwhisper), Holimion (Diamonddew), Ilphelkiir (Gem blossom ), Liadon (Silverfrond), \nMeliamne (Oakenheel), Nai'lo (Nightbreeze), Siannodel (Moonbrook), Xiloscient (Goldpetal)");
				break;
			case "Halfling":
				if(Gender.equals("Male")){
					System.out.println("Male Names: Alton, Ander, Cade, Corrin, Eldon, Errich, Finnan, Garret, Lindal, \nLyle, Merric, Milo, Osborn, Perrin, Reed, Roscoe, Wellby");
				} else if(Gender.equals("Female")){
					System.out.println("Female Names: Andry, Bree, Callie, Cora, Euphemia, Jillian, Kithri, Lavinia, \nLidda, Merla, Nedda, Paela, Portia, Seraphina, Shaena, Trym, Vani, Verna");
				} else{
					System.out.println("Male Names: Alton, Ander, Cade, Corrin, Eldon, Errich, Finnan, Garret, Lindal, \nLyle, Merric, Milo, Osborn, Perrin, Reed, Roscoe, Wellby");
					System.out.println("Female Names: Andry, Bree, Callie, Cora, Euphemia, Jillian, Kithri, Lavinia, \nLidda, Merla, Nedda, Paela, Portia, Seraphina, Shaena, Trym, Vani, Verna");
				} System.out.println("Family Names: Brushgather, Goodbarrel, Greenbottle, High-hill, Hilltopple, Leagallow, \nTealeaf, Thorngage, Tosscobble, Underbough");
				break;
			case "Human":
				if(Gender.equals("Male")){
					System.out.println("It shouldn't be that hard for you to come up with a human name.");
				} else if(Gender.equals("Female")){
					System.out.println("It shouldn't be that hard for you to come up with a human name.");
				} else{
					System.out.println("It shouldn't be that hard for you to come up with a human name.");
				}
				break;
			case "Dragonborn":
				if(Gender.equals("Male")){
					System.out.println("Male Names: Arjhan, Balasar, Bharash, Donaar, Ghesh. Heskan, Kriv, Medrash, Mehen, \nNadarr, Pandjed, Patrin, Rhogar, Shamash, Shedinn, Tarhun, Torinn");
				} else if(Gender.equals("Female")){
					System.out.println("Female Names: Akra, Biri, Daar, Farideh, Harann, Flavilar, Jheri, Kava, Korinn, \nMishann, Nala, Perra, Raiann, Sora, Surina, Thava, Uadjit");
				} else{
					System.out.println("Male Names: Arjhan, Balasar, Bharash, Donaar, Ghesh. Heskan, Kriv, Medrash, Mehen, \nNadarr, Pandjed, Patrin, Rhogar, Shamash, Shedinn, Tarhun, Torinn");
					System.out.println("Female Names: Akra, Biri, Daar, Farideh, Harann, Flavilar, Jheri, Kava, Korinn, \nMishann, Nala, Perra, Raiann, Sora, Surina, Thava, Uadjit");
				} System.out.println("Clan Names: Clethtinthiallor, Daardendrian, Delmirev, Drachedandion, Fenkenkabradon, \nKepeshkm olik, Kerrhylon, Kimbatuul, Linxakasendalor, Myastan, Nem monis, Norixius, \nOphinshtalajiir, Prexijandilin, Shestendeliath, Turnuroth, Verthisathurgiesh, Yarjerit");
				break;
			case "Gnome":
				if(Gender.equals("Male")){
					System.out.println("Male Names: Alston, Alvyn, Boddynock, Brocc, Burgell, Dimble, Eldon, Erky, Fonkin, \nFrug, Gerbo, Gimble, Glim, Jebeddo, Kellen, Namfoodle, Orryn, Roondar, Seebo, Sindri, \nWarryn, Wrenn, Zook");
				} else if(Gender.equals("Female")){
					System.out.println("Female Names: Bimpnottin, Breena, Caramip, Carlin, Donella, Duvamil, Ella, Ellyjobell, \nEllywick, Lilli, Loopmottin, Lorilla, Mardnab, Nissa, Nyx, Oda, Orla, Roywyn, Shamil, \nTana, Waywocket, Zanna");
				} else{
					System.out.println("Male Names: Alston, Alvyn, Boddynock, Brocc, Burgell, Dimble, Eldon, Erky, Fonkin, \nFrug, Gerbo, Gimble, Glim, Jebeddo, Kellen, Namfoodle, Orryn, Roondar, Seebo, Sindri, \nWarryn, Wrenn, Zook");
					System.out.println("Female Names: Bimpnottin, Breena, Caramip, Carlin, Donella, Duvamil, Ella, Ellyjobell, \nEllywick, Lilli, Loopmottin, Lorilla, Mardnab, Nissa, Nyx, Oda, Orla, Roywyn, Shamil, \nTana, Waywocket, Zanna");
				} System.out.println("Clan Names: Beren, Daergel, Folkor, Garrick, Nackle, Murnig, Ningel, Raulnor, Scheppen, \nTimbers, Turen ");
				System.out.println("Nicknames: Aleslosh, Ashhearth, Badger, Cloak, Doublelock, Filchbatter, Fnipper, Ku, \nNim, Oneshoe, Pock, Sparklegem, Stumbleduck");
				break;
			case "Half-elf":
				if(Gender.equals("Male")){
					System.out.println("Male Names: Adran, Aelar, Aramil, Arannis, Aust, Beiro, Berrian, Carric , Enialis, \nErdan, Erevan, Galinndan, Hadarai, Heian, Himo, Immeral, Ivellios, Laucian, Mindartis, \nPaelias, Peren, Quarion, Riardon, Rolen, Soveliss, Thamior, Tharivol, Theren, Varis");
				} else if(Gender.equals("Female")){
					System.out.println("Female Names: Adrie, Althaea, Anastrianna, Andraste, Antinua, Bethrynna, Birel, \nCaelynn, Drusilia, Enna, Felosial, Ielenia, Jelenneth, Keyleth, Leshanna, Lia, Meriele, \nMialee, Naivara, Quelenna, Quillathe, Sariel, Shanairra, Shava, Silaqui, Theirastra, \nThia, Vadania, Valanthe, Xanaphia ");
				} else{
					System.out.println("Male Names: Adran, Aelar, Aramil, Arannis, Aust, Beiro, Berrian, Carric , Enialis, \nErdan, Erevan, Galinndan, Hadarai, Heian, Himo, Immeral, Ivellios, Laucian, Mindartis, \nPaelias, Peren, Quarion, Riardon, Rolen, Soveliss, Thamior, Tharivol, Theren, Varis");
					System.out.println("Female Names: Adrie, Althaea, Anastrianna, Andraste, Antinua, Bethrynna, Birel, \nCaelynn, Drusilia, Enna, Felosial, Ielenia, Jelenneth, Keyleth, Leshanna, Lia, Meriele, \nMialee, Naivara, Quelenna, Quillathe, Sariel, Shanairra, Shava, Silaqui, Theirastra, \nThia, Vadania, Valanthe, Xanaphia ");
				} System.out.println("Family Names (Common Translations): Amakiir (Gemflower), Amastacia (Starflower), \nGalanodel (Moonwhisper), Holimion (Diamonddew), Ilphelkiir (Gem blossom ), Liadon (Silverfrond), \nMeliamne (Oakenheel), Nai'lo (Nightbreeze), Siannodel (Moonbrook), Xiloscient (Goldpetal)");
				break;
			case "Half-orc":
				if(Gender.equals("Male")){
					System.out.println("Male Orc Names: Dench, Feng, Gell, Henk, Holg, Imsh, Keth, Krusk, Mhurren, Ront, \nShump, Thokk");
				} else if(Gender.equals("Female")){
					System.out.println("Female Orc Names: Baggi, Emen, Engong, Kansif, Myev, Neega, Ovak, Ownka, Shautha, \nSutha, Vola, Volen, Yevelda");
				} else{
					System.out.println("Male Orc Names: Dench, Feng, Gell, Henk, Holg, Imsh, Keth, Krusk, Mhurren, Ront, \nShump, Thokk");
					System.out.println("Female Orc Names: Baggi, Emen, Engong, Kansif, Myev, Neega, Ovak, Ownka, Shautha, \nSutha, Vola, Volen, Yevelda");
				}
				break;
			case "Tiefling":
				if(Gender.equals("Male")){
					System.out.println("Male Infernal Names: Akmenos, Amnon, Barakas, Damakos, Ekemon, Iados, Kairon, Leucis, \nMelech, Mordai, Morthos, Pelaios, Skamos, Therai");
				} else if(Gender.equals("Female")){
					System.out.println("Female Infernal Names: Akta, Anakis, Bryseis, Criella, Damaia, Ea, Kallista, Lerissa, Makaria, Nemeia, Orianna, Phelaia, Rieta");
				} else{
					System.out.println("Male Infernal Names: Akmenos, Amnon, Barakas, Damakos, Ekemon, Iados, Kairon, Leucis, \nMelech, Mordai, Morthos, Pelaios, Skamos, Therai");
					System.out.println("Female Infernal Names: Akta, Anakis, Bryseis, Criella, Damaia, Ea, Kallista, Lerissa, \nMakaria, Nemeia, Orianna, Phelaia, Rieta");
				} System.out.println("\"Virtue\" Names: Art, Carrion, Chant, Creed, Despair, Excellence, Fear, Glory, Hope, \nIdeal, Music, Nowhere, Open, Poetry, Quest, Random, Reverence, Sorrow, Temerity, Torment, \nWeary");
				break;
			}characterName = userInput.nextLine();
		} return characterName;
	}
	public static int[] characterStats(String Race, String Class){
		Random generator = new Random();
		Scanner userInput = new Scanner(System.in);
		int[] Stats = new int[6];
		int[] Rolling = new int[4];
		for(int i=0;i<6;i++){
			for(int x=0;x<4;x++){
				Rolling[x] = generator.nextInt(6)+1;
			}Arrays.sort(Rolling);
			Stats[i] = Rolling[1] + Rolling[2] + Rolling[3];
		} Arrays.sort(Stats);
		System.out.println("Your rolled stats(before applying race boosts) are " + Stats[0] + ", " + Stats[1] + ", " + Stats[2] + ", " + Stats[3] + ", " + Stats[4] + ", and " + Stats[5]);
		System.out.println("Now, remembering the important stats I gave you when you were choosing \na race, you can order your rolls. As you see stat names, rate the place \nyou want that stat to be in. For example, if you saw strength you \ncould type 1 to indicate that strength should have the highest stat. Or \nwhen you saw Intelligence you could write 6 to indicate that you want \nIntelligence as your lowest stat. Remember, there are 6 stats.");
		int[] statOrder = new int[6];
		System.out.println("Strength");
		statOrder[0] = userInput.nextInt();
		System.out.println("Dexterity");
		statOrder[1] = userInput.nextInt();
		System.out.println("Constitution");
		statOrder[2] = userInput.nextInt();
		System.out.println("Intelligence");
		statOrder[3] = userInput.nextInt();
		System.out.println("Wisdom");
		statOrder[4] = userInput.nextInt();
		System.out.println("Charisma");
		statOrder[5] = userInput.nextInt();
		int[] characterStats = new int[6];
		for(int i = 0;i < 6;i++){
			switch(statOrder[i]){
			case 1:
				characterStats[i] = Stats[5];
				break;
			case 2:
				characterStats[i] = Stats[4];
				break;
			case 3:
				characterStats[i] = Stats[3];
				break;
			case 4:
				characterStats[i] = Stats[2];
				break;
			case 5:
				characterStats[i] = Stats[1];
				break;
			case 6:
				characterStats[i] = Stats[0];
				break;
			}
		}switch(Race){
		case "Elf":
			characterStats[1] += 2;
			System.out.println("For the stat bonus that comes with being an Elf, would you like to apply\n1. +1 to Intelligence(high elf)\n2. +1 to Wisdom(wood elf)\n3. +1 to Charisma(drow)");
			int elfStatBonus = userInput.nextInt();
			if(elfStatBonus == 1){
				characterStats[3]++;
			} else if(elfStatBonus == 2){
				characterStats[4]++;
			} else if(elfStatBonus==3){
				characterStats[5]++;
			} else{
				System.out.println("That wasn't an option. Your attribute bonus has defaulted to Intelligence");
				characterStats[3]++;
			}
			break;
		case "Dwarf":
			characterStats[2] += 2;
			System.out.println("For the stat bonus that comes with being a Dwarf, would you like to apply\n1. +2 to Strength(mountain dwarf)\n2. +1 to Wisdom(hill dwarf)");
			int dwarfStatBonus = userInput.nextInt();
			if(dwarfStatBonus == 1){
				characterStats[0] += 2;
			} else if(dwarfStatBonus == 2){
				characterStats[4]++;
			} else{
				System.out.println("That wasn't an option. Your attribute bonus has defaulted to Strength");
				characterStats[0] += 2;
			} break;
		case "Halfling":
			characterStats[1] += 2;
			System.out.println("For the stat bonus that comes with being a Halfling, would you like to apply\n1. +1 to Constitution(stout)\n2. +1 to Charisma(lightfoot)");
			int halflingStatBonus = userInput.nextInt();
			if(halflingStatBonus == 1){
				characterStats[2]++;
			} else if(halflingStatBonus == 2){
				characterStats[5]++;
			} else{
				System.out.println("That wasn't an option. Your attribute bonus has defaulted to Constitution");
				characterStats[2]++;
			}
			break;
		case "Human":
			for(int x=0;x<6;x++){
				characterStats[x]++;
			}
				break;
			case "Dragonborn":
				characterStats[0] += 2;
				characterStats[5]++;
				break;
			case "Gnome":
				characterStats[3] += 2;
				System.out.println("For the stat bonus that comes with being a Gnome, would you like to apply\n1. +1 Dexterity(forest gnome)\n2. +1 Constitution(rock gnome)");
				int gnomeStatBonus = userInput.nextInt();
				if(gnomeStatBonus == 1){
					characterStats[1]++;
				} else if(gnomeStatBonus == 2){
					characterStats[2]++;
				} else{
					System.out.println("That wasn't an option. Your attribute bonus has defaulted to Dexterity");
					characterStats[1]++;
				}
				break;
			case "Half-elf":
				characterStats[5] += 2;
				System.out.println("For the stat bonus that comes with being a Half-elf, which attribute would you like to apply +1 to first?\n1. Strength\n2. Dexterity\n3. Constitution\n4. Intelligence\n5. Wisdom\n6. Charisma");
				int halfelfStatBonus = userInput.nextInt();
				switch(halfelfStatBonus){
				case 1:
					characterStats[0]++;
					break;
				case 2:
					characterStats[1]++;
					break;
				case 3:
					characterStats[2]++;
					break;
				case 4:
					characterStats[3]++;
					break;
				case 5:
					characterStats[4]++;
					break;
				case 6:
					characterStats[5]++;
					break;
				default:
					System.out.println("That wasn't an option. Your first attribute bonus has defaulted to Constitution.");
					characterStats[2]++;
				} System.out.println("For the second stat bonus that comes with being a Half-elf, which (different)attribute would \nyou like to apply +1 to?(Use the numbers from the previous question.");
				halfelfStatBonus = userInput.nextInt();
				switch(halfelfStatBonus){
				case 1:
					characterStats[0]++;
					break;
				case 2:
					characterStats[1]++;
					break;
				case 3:
					characterStats[2]++;
					break;
				case 4:
					characterStats[3]++;
					break;
				case 5:
					characterStats[4]++;
					break;
				case 6:
					characterStats[5]++;
					break;
				default:
					System.out.println("That wasn't an option. Your second attribute bonus has defaulted to Dexterity.");
					characterStats[1]++;
				}
				break;
			case "Half-orc":
				characterStats[0] += 2;
				characterStats[2]++;
				break;
			case "Tiefling":
				characterStats[5] += 2;
				characterStats[2]++;
				break;
			} System.out.println("With your racial stat bonuses applied, these are your stats.");
			System.out.println("Strength - " + characterStats[0]);
			System.out.println("Dexterity - " + characterStats[1]);
			System.out.println("Constitution - " + characterStats[2]);
			System.out.println("Intelligence - " + characterStats[3]);
			System.out.println("Wisdom - " + characterStats[4]);
			System.out.println("Charisma - " + characterStats[5]);
			return characterStats;
		}
	public static int[] characterModifiers(int[] Stats){
		int[] Modifiers = new int[6];
		for(int i=0;i<6;i++){
			switch(Stats[i]){
			case 3:
				Modifiers[i] = -4;
				break;
			case 4:
			case 5:
				Modifiers[i] = -3;
				break;
			case 6:
			case 7:
				Modifiers[i] = -2;
				break;
			case 8:
			case 9:
				Modifiers[i] = -1;
				break;
			case 10:
			case 11:
				Modifiers[i] = 0;
				break;
			case 12:
			case 13:
				Modifiers[i] = 1;
				break;
			case 14:
			case 15:
				Modifiers[i] = 2;
				break;
			case 16:
			case 17:
				Modifiers[i] = 3;
				break;
			case 18:
			case 19:
				Modifiers[i] = 4;
				break;
			case 20:
				Modifiers[i] = 5;
				break;
			}
		} return Modifiers;
	}
	public static Skill[] characterSkills(int[] characterModifiers, String characterRace, String characterClass, String characterBackground){
		Scanner userInput = new Scanner(System.in);
		int[] stat = new int[19];
		String backgroundProficiency1="";
		String backgroundProficiency2="";
		switch(characterBackground) {
			case "Acolyte":
				backgroundProficiency1="Insight";
				backgroundProficiency2="Religion";
				stat[6]=2;
				stat[14]=2;
				break;
			case "Charlatan":
				backgroundProficiency1="Deception";
				backgroundProficiency2="Sleight of Hand";
				stat[4]=2;
				stat[15]=2;
				break;
			case "Entertainer":
				backgroundProficiency1="Acrobatics";
				backgroundProficiency2="Performance";
				stat[0]=2;
				stat[12]=2;
				break;
			case "Criminal":
				backgroundProficiency1="Deception";
				backgroundProficiency2="Stealth";
				stat[4]=2;
				stat[16]=2;
				break;
			case "Folk Hero":
				backgroundProficiency1="Animal Handling";
				backgroundProficiency2="Survival";
				stat[1]=2;
				stat[17]=2;
				break;
			case "Guild Artisan":
				backgroundProficiency1="Insight";
				backgroundProficiency2="Persuasion";
				stat[6]=2;
				stat[13]=2;
				break;
			case "Hermit":
				backgroundProficiency1="Medicine";
				backgroundProficiency2="Religion";
				stat[9]=2;
				stat[14]=2;
				break;
			case "Noble":
				backgroundProficiency1="History";
				backgroundProficiency2="Persuasion";
				stat[5]=2;
				stat[13]=2;
				break;
			case "Outlander":
				backgroundProficiency1="Athletics";
				backgroundProficiency2="Survival";
				stat[3]=2;
				stat[17]=2;
				break;
			case "Sage":
				backgroundProficiency1="Arcana";
				backgroundProficiency2="History";
				stat[2]=2;
				stat[5]=2;
				break;
			case "Sailor":
				backgroundProficiency1="Athetics";
				backgroundProficiency2="Perception";
				stat[3]=2;
				stat[11]=2;
				break;
			case "Soldier":
				backgroundProficiency1="Athletics";
				backgroundProficiency2="Intimidation";
				stat[3]=2;
				stat[7]=2;
				break;
			case "Urchin":
				backgroundProficiency1="Sleight of Hand";
				backgroundProficiency2="Stealth";
				stat[15]=2;
				stat[16]=2;
				break;
		}
		System.out.println("Due to your background of " + characterBackground+ ", you already have proficiency in "+ backgroundProficiency1 + " and " + backgroundProficiency2 + ".");
		switch(characterRace){
			case "Elf":
				System.out.println("Due to your race of Elf, you already have proficiency in Perception");
				stat[11]=2;
				break;
			case "Half-elf":
				System.out.println("Due to your race of Half-elf, you can choose two proficiencies. Type the numbers of your chosen proficiencies consecutively.");
				System.out.println("0. Acrobatics\n1. Animal Handling\n2. Arcana\n3. Athletics\n4. Deception\n5. History\n6. Insight\n7. Intimidation\n8. Investigation\n9. Medicine\n10. Nature\n11. Perception\n12. Performance\n13. Persuasion\n14. Religion\n15. Sleight of Hand\n16. Stealth\n17.Survival");
				stat[userInput.nextInt()] = 2;
				stat[userInput.nextInt()] = 2;
		}
		ArrayList<String> classProficiencyChoices = new ArrayList();
		switch(characterClass){
			case "Barbarian":
				classProficiencyChoices.add("1. Animal Handling");
				classProficiencyChoices.add("3. Athletics");
				classProficiencyChoices.add("7. Intimidation");
				classProficiencyChoices.add("10. Nature");
				classProficiencyChoices.add("12. Perception");
				classProficiencyChoices.add("17. Survival");
				break;
			case "Bard":
				classProficiencyChoices.add("0. Acrobatics");
				classProficiencyChoices.add("1. Animal Handling");
				classProficiencyChoices.add("2. Arcana");
				classProficiencyChoices.add("3. Athletics");
				classProficiencyChoices.add("4. Deception");
				classProficiencyChoices.add("5. History");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("7. Intimidation");
				classProficiencyChoices.add("8. Investigation");
				classProficiencyChoices.add("9. Medicine");
				classProficiencyChoices.add("10. Nature");
				classProficiencyChoices.add("11. Perception");
				classProficiencyChoices.add("12. Perception");
				classProficiencyChoices.add("13. Persuasion");
				classProficiencyChoices.add("14. Religion");
				classProficiencyChoices.add("15. Sleight of Hand");
				classProficiencyChoices.add("16. Stealth");
				classProficiencyChoices.add("17. Survival");
			case "Cleric":
				classProficiencyChoices.add("5. History");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("9. Medicine");
				classProficiencyChoices.add("13. Persuasion");
				classProficiencyChoices.add("14. Religion");
				break;
			case "Druid":
				classProficiencyChoices.add("1. Animal Handling");
				classProficiencyChoices.add("2. Arcana");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("9. Medicine");
				classProficiencyChoices.add("10. Nature");
				classProficiencyChoices.add("11. Perception");
				classProficiencyChoices.add("14. Religion");
				classProficiencyChoices.add("17. Survival");
				break;
			case "Fighter":
				classProficiencyChoices.add("0. Acrobatics");
				classProficiencyChoices.add("1. Animal Handling");
				classProficiencyChoices.add("3. Athletics");
				classProficiencyChoices.add("5. History");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("7. Intimidation");
				classProficiencyChoices.add("11. Perception");
				classProficiencyChoices.add("17. Survival");
				break;
			case "Monk":
				classProficiencyChoices.add("0. Acrobatics");
				classProficiencyChoices.add("3. Athletics");
				classProficiencyChoices.add("5. History");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("14. Religion");
				classProficiencyChoices.add("16. Stealth");
				break;
			case "Paladin":
				classProficiencyChoices.add("3. Athletics");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("7. Intimidation");
				classProficiencyChoices.add("9. Medicine");
				classProficiencyChoices.add("13. Persuasion");
				classProficiencyChoices.add("14. Religion");
				break;
			case "Ranger":
				classProficiencyChoices.add("1. Animal Handling");
				classProficiencyChoices.add("3. Athletics");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("8. Investigation");
				classProficiencyChoices.add("10. Nature");
				classProficiencyChoices.add("11. Perception");
				classProficiencyChoices.add("16. Stealth");
				classProficiencyChoices.add("17.Survival");
				break;
			case "Rogue":
				classProficiencyChoices.add("0. Acrobatics");
				classProficiencyChoices.add("3. Athletics");
				classProficiencyChoices.add("4. Deception");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("7. Intimidation");
				classProficiencyChoices.add("8. Investigation");
				classProficiencyChoices.add("11. Perception");
				classProficiencyChoices.add("15. Sleight of Hand");
				classProficiencyChoices.add("16. Stealth");
				break;
			case "Sorcerer":
				classProficiencyChoices.add("2. Arcana");
				classProficiencyChoices.add("4. Deception");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("7. Intimidation");
				classProficiencyChoices.add("13. Persuasion");
				classProficiencyChoices.add("14. Religion");
				break;
			case "Warlock":
				classProficiencyChoices.add("2. Arcana");
				classProficiencyChoices.add("4. Deception");
				classProficiencyChoices.add("5. History");
				classProficiencyChoices.add("7. Intimidation");
				classProficiencyChoices.add("8. Investigation");
				classProficiencyChoices.add("10. Nature");
				classProficiencyChoices.add("14. Religion");
				break;
			case "Wizard":
				classProficiencyChoices.add("2. Arcana");
				classProficiencyChoices.add("5. History");
				classProficiencyChoices.add("6. Insight");
				classProficiencyChoices.add("8. Investigation");
				classProficiencyChoices.add("9. Medicine");
				classProficiencyChoices.add("14. Religion");
				break;
		}
		if(characterClass=="Bard") {
			System.out.println("For your class of Bard, choose 3 skill proficiencies from the following list. Type the numbers of the proficiencies you want consecutively.");
			for (int i=0;i<classProficiencyChoices.size();i++) {
				System.out.println(classProficiencyChoices.get(i));
			}
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
		} else if(characterClass=="Ranger"){
			System.out.println("For your class of Ranger, choose 3 skill proficiencies from the following list. Type the numbers of the proficiencies you want consecutively.");
			for (int i=0;i<classProficiencyChoices.size();i++) {
				System.out.println(classProficiencyChoices.get(i));
			}
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
		} else if(characterClass=="Rogue"){
			System.out.println("For your class of Rogue, choose 4 skill proficiencies from the following list. Type the numbers of the proficiencies you want consecutively.");
			for (int i=0;i<classProficiencyChoices.size();i++) {
				System.out.println(classProficiencyChoices.get(i));
			}
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
		} else {
			System.out.println("For your class of " + characterClass + ", choose 2 skill proficiencies from the following list. Type the numbers of the proficiencies you want consecutively.");
			for (int i=0;i<classProficiencyChoices.size();i++) {
				System.out.println(classProficiencyChoices.get(i));
			}
			stat[userInput.nextInt()]=2;
			stat[userInput.nextInt()]=2;
		}
		acrobatics = new Skill(0, "Acrobatics", stat[0], characterModifiers[1]);
		animalHandling = new Skill(1, "Animal Handling", stat[1], characterModifiers[4]);
		arcana = new Skill(2, "Arcana", stat[2], characterModifiers[3]);
		athletics = new Skill(3, "Athletics", stat[3], characterModifiers[0]);
		deception = new Skill(4, "Deception", stat[4], characterModifiers[5]);
		history = new Skill(5, "History", stat[5], characterModifiers[3]);
		insight = new Skill(6, "Insight", stat[6], characterModifiers[4]);
		intimidation = new Skill(7, "Intimidation", stat[7], characterModifiers[5]);
		investigation = new Skill(8, "Investigation", stat[8], characterModifiers[3]);
		medicine = new Skill(9, "Medicine", stat[9], characterModifiers[4]);
		nature = new Skill(10, "Nature", stat[10], characterModifiers[3]);
		perception = new Skill(11, "Perception", stat[11], characterModifiers[4]);
		performance = new Skill(12, "Performance", stat[12], characterModifiers[5]);
		persuasion = new Skill(13, "Persuasion", stat[13], characterModifiers[5]);
		religion = new Skill(14, "Religion", stat[14], characterModifiers[3]);
		sleightOfHand = new Skill(15, "Sleight of Hand", stat[15], characterModifiers[1]);
		stealth = new Skill(16, "Stealth", stat[16], characterModifiers[1]);
		survival = new Skill(17, "Survival", stat[17], characterModifiers[4]);
		Skill[] characterSkills = new Skill[18];
		characterSkills[0] = acrobatics;
		characterSkills[1] = animalHandling;
		characterSkills[2] = arcana;
		characterSkills[3] = athletics;
		characterSkills[4] = deception;
		characterSkills[5] = history;
		characterSkills[6] = insight;
		characterSkills[7] = intimidation;
		characterSkills[8] = investigation;
		characterSkills[9] = medicine;
		characterSkills[10] = nature;
		characterSkills[11] = perception;
		characterSkills[12] = performance;
		characterSkills[13] = persuasion;
		characterSkills[14] = religion;
		characterSkills[15] = sleightOfHand;
		characterSkills[16] = stealth;
		characterSkills[17] = survival;
		return characterSkills;
	}
	public static int[] characterSavingThrows(int[] Modifiers){
		int[] savingThrows = new int[6];
		savingThrows[1] = Modifiers[1];
		savingThrows[2] = Modifiers[2];
		savingThrows[3] = Modifiers[3];
		savingThrows[4] = Modifiers[4];
		savingThrows[5] = Modifiers[5];
		savingThrows[6] = Modifiers[6];
		return savingThrows;
	}
	public static String characterAlignment(String characterRace) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Now you should choose an alignment for your character. The alignments are Lawful Good, \nLawful Neutral, Lawful Evil, Neutral Good, True Neutral, Neutral Evil, Chaotic \nGood, Chaotic Neutral, and Chaotic Evil.");
		switch(characterRace) {
			case "Dwarf":
			System.out.println("Most dwarves are lawful, believing firmly in the benefits of a well-ordered society. \nThey tend toward good as well, with a strong sense of fair play and a belief \nthat everyone deserves to share in the benefits of a just order.");
			break;
			case "Elf":
			System.out.println("Elves love freedom, variety, and self-expression, so they lean strongly towards the \ngentler aspects of chaos. They value and protect others' freedom as well as \ntheir own, and they are more often good than not. The drow are an exception: \ntheir exile into the Underdark has made them vicious and dangerous. \nDrow are more often evil than not.");
			break;
			case "Halfling":
			System.out.println("Most halflings are lawful good. As a rule, they are good-hearted and kind, hate to see \nothers in pain, and have no tolerance for oppression. They are also very \norderly and traditional, leaning heavily on the support of their community and \nthe comfort of their old ways.");
			break;
			case "Human":
			System.out.println("Humans tend toward no particular alignment. The best and the worst are found among them.");
			break;
			case "Dragonborn":
			System.out.println("Dragonborn tend to extremes, making a conscious choice for one side or the other in the \ncosmic war between good and evil (represented by Bahamut and Tiamat, \nrespectively). Most dragonborn are good, but those who side with Tiamat can be \nterrible villains.");
			break;
			case "Gnome":
			System.out.println("Gnomes are most often good. Thpse who tend toward law are sages, engineers, researchers, \nscholars, investigators, or inventors. Those who tend toward chaos are \nminstrels, tricksters, wanderers, or fanciful jewelers. Gnomes are good-hearted, \nand even the tricksters among them are more playful than vicious.");
			break;
			case "Half-elf":
			System.out.println("Half-elves share the chaotic bent of their elven heritage. They value both personal freedom \nand creative expression, demonstrating neither love of leaders nor \ndesire for followers. They chafe at rulers, resent others' demands, and sometimes \nprove unreliable, or at least unpredictable.");
			break;
			case "Half-orc":
			System.out.println("Half-orcs inherit a tendency toward chaos from their orc parents and are not strongle \ninclined toward good. Half-orcs raised among orcs and willing to live out \ntheir lives among them are usually evil.");
			break;
			case "Tiefling":
			System.out.println("Tieflings might not have an innate tendency toward evil, but many of them end up there. \nEvil or not, an independent nature inclines many tieflings toward a \nchaotic alignment.");
			break;
		}
		System.out.println("Please indicate your character's chosen alignment using a two letter combination, such as LG or TN.");
		return userInput.nextLine();
	}
	public static String[] characterBackground(){
		Random generator = new Random();
		Scanner userInput = new Scanner(System.in);
		System.out.println("Now you should choose a background. This is your character's profession \nin your backstory. For the campaign you play in it's your choice whether or not they still \ndo this, but they did in the past. The choices are:\n1. Acolyte\n2. Charlatan\n3. Criminal\n4. Entertainer\n5. Guild Artisan\n6. Hermit\n7. Noble\n8. Outlander\n9. Sage\n10. Sailor\n11. Soldier");
		String[] Background = new String[5];
		int BackgroundNum = userInput.nextInt();
		String BackgroundNum2 = "";
		switch(BackgroundNum){
		case 1:
			System.out.println("You chose Acolyte");
			Background[0] = "Acolyte";
			System.out.println("Now you must choose a personality trait from this list\n1. I idolize a particular hero of my faith, and constantly refer to that person's deeds nad example. \n2. I can find common ground between the fiercest enemies, empathizing with them and always working towards peace.\n3. I see omens in every event and action. The gods speak to us, we just need to listen.\n4. Nothing can shake my optimistic attitude.\n5. I quote (or misquote) sacred texts and proverbs in almost every situation.\n6. I am tolerant (or intolerant) of other faiths and respect (or condemn) the worship of other gods.\n7. I've enjoyed fine food, drink, and high society among my temple's elite. Rough living grates on me.\n8. I've spent so long in the temple that I have little practical experience dealing with people in the outside world.");
			BackgroundNum2 = userInput.nextLine();
			BackgroundNum2 = userInput.nextLine();
			Background[1] = BackgroundNum2;
			System.out.println("Now you must choose an ideal from this list\n1. Tradition. The ancient traditions of worship and sacrifice must be preserved and upheld. (Lawful)\n2. Charity. I always try to help those in need, no matter what the personal cost. (Good)\n3. Change. We must always help bring about the changes the gods are constantly working in the world. (Chaotic)\n4. Power. I hope to one day rise to the top of my faith's religious hierarchy. (Lawful)\n5. Faith. I trust that my deity will guide my actions. I have faith that if I work hard, things will go well. (Lawful)\n6. Aspiration. I seek to prove ");
			BackgroundNum2 = userInput.nextLine();
			Background[2] = BackgroundNum2;
			System.out.println("Now you must choose a personality trait from this list\n1.");
			BackgroundNum2 = userInput.nextLine();
			Background[3] = BackgroundNum2;
			System.out.println("Now you must choose a personality trait from this list\n1.");
			BackgroundNum2 = userInput.nextLine();
			Background[4] = BackgroundNum2;

			break;
		case 2:
			System.out.println("You chose Charlatan");
			Background[0] = "Charlatan";
			break;
		case 3:
			System.out.println("You chose Criminal");
			Background[0] = "Criminal";
			break;
		case 4:
			System.out.println("You chose Entertainer");
			Background[0] = "Entertainer";
			break;
		case 5:
			System.out.println("You chose Guild Artisan");
			Background[0] = "Guild Artisan";
			break;
		case 6:
			System.out.println("You chose Hermit");
			Background[0] = "Hermit";
			break;
		case 7:
			System.out.println("You chose Noble");
			Background[0] = "Noble";
			break;
		case 8:
			System.out.println("You chose Outlander");
			Background[0] = "Outlander";
			break;
		case 9:
			System.out.println("You chose Sage");
			Background[0] = "Sage";
			break;
		case 10:
			System.out.println("You chose Folk Hero");
			Background[0] = "Sailor";
			break;
		case 11:
			System.out.println("You chose Soldier");
			Background[0] = "Soldier";
			break;
		default:
			System.out.println("That wasn't an option. Your background has defaulted to Noble.");
			Background[0] = "Noble";
			break;
		} return Background;
	}
}
