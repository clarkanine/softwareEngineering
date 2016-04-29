package gamePack.gameStatePack;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ProfileSourceHandler {

	/*
	profileName: kevin
	characterName: defaultCharacterName
	weaponName: defaultWeaponName
	difficulty: 0
	experience: 0
	 */


	private final static String profileNamePatStr = "[a-zA-Z0-9]+";
	private final static Pattern profileNamePattern = Pattern.compile(profileNamePatStr);

	private final static String characterNamePatStr = "[a-zA-Z0-9]+";
	private final static Pattern characterNamePattern = Pattern.compile(characterNamePatStr);

	private final static String weaponNamePatStr = "[a-zA-Z0-9]+";
	private final static Pattern weaponNamePattern = Pattern.compile(weaponNamePatStr);

	private final static String difficultyPatStr = "[0-9]+";
	private final static Pattern difficultyPattern = Pattern.compile(difficultyPatStr);

	private final static String experiencePatStr = "[0-9]+";
	private final static Pattern experiencePattern = Pattern.compile(experiencePatStr);

	private final static String profilePatStr = "profileName\\:\\s"+profileNamePatStr+"\\n*"
			+"characterName\\:\\s"+characterNamePatStr+"\\n*"
			+"weaponName\\:\\s"+weaponNamePatStr+"\\n*"
			+"difficulty\\:\\s"+difficultyPatStr+"\\n*"											
			+"experience\\:\\s"+experiencePatStr+"\\n*";



	private final static Pattern profilePattern = Pattern.compile(profilePatStr);

	private static String profileSourceName = "";
	private static String configPathA = "GameData/ProfileSource_";
	private static String configPathB = "."+configPathA;
	
	private static String getConfigPath() {
		String filepath = configPathA;
		if(System.console()==null)
			filepath = configPathA;
		else
			filepath = configPathB;
		return filepath;
	}

	private static String configString = "";
	
	protected static String getConfigString() {
		String filepath = getConfigPath() + profileSourceName;
		Scanner sc;
		int count = 0;
		try {
			sc = new Scanner(new File(filepath));
			while(sc.hasNextLine()) {
				String cur = sc.nextLine()+"\n";
				//System.out.println(cur);
				configString += cur;
				count++;
			}
		} catch (FileNotFoundException e) { e.printStackTrace(); }
		//System.out.println("numLinesFound: "+count);
		return configString;
	}
	
	
	
	protected static void profileSourceParser(String profileName) {
		
		profileSourceName = profileName;
		getConfigString();
		
		Matcher profileMatcher = profilePattern.matcher(configString);
		profileMatcher.find();
		String profileString = configString.substring(profileMatcher.start(), profileMatcher.end()); //valid profileString
		//System.out.println("configString:profileString:\n"+profileString);

		Matcher profileNameMatcher = Pattern.compile("profileName\\:\\s"+profileNamePatStr+"\\n*").matcher(profileString);
		profileNameMatcher.find();
		String profileNameString = profileString.substring(profileNameMatcher.start(), profileNameMatcher.end());
		profileNameString = profileNameString.substring(13, profileNameString.length()-1);
		//System.out.println("newParsedString:profileName: "+profileNameString);

		Matcher characterNameMatcher = Pattern.compile("characterName\\:\\s"+characterNamePatStr+"\\n*").matcher(profileString);
		characterNameMatcher.find(profileNameMatcher.end());
		String characterNameString = profileString.substring(characterNameMatcher.start(), characterNameMatcher.end());
		characterNameString = characterNameString.substring(15, characterNameString.length()-1);
		//System.out.println("newParsedString:characterName: "+characterNameString);

		Matcher weaponNameMatcher = Pattern.compile("weaponName\\:\\s"+weaponNamePatStr+"\\n*").matcher(profileString);
		weaponNameMatcher.find(characterNameMatcher.end());
		String weaponNameString = profileString.substring(weaponNameMatcher.start(), weaponNameMatcher.end());
		weaponNameString = weaponNameString.substring(12, weaponNameString.length()-1);
		//System.out.println("newParsedString:weaponName: "+weaponNameString);

		Matcher difficultyMatcher = Pattern.compile("difficulty\\:\\s"+difficultyPatStr+"\\n*").matcher(profileString);
		difficultyMatcher.find(weaponNameMatcher.end());
		String difficultyString = profileString.substring(difficultyMatcher.start(), difficultyMatcher.end());
		difficultyString = difficultyString.substring(12, difficultyString.length()-1);
		int difficultyInt = Integer.valueOf(difficultyString);
		//System.out.println("newParsedInt:difficulty: "+difficultyInt);

		Matcher experienceMatcher = Pattern.compile("experience\\:\\s"+experiencePatStr+"\\n*").matcher(profileString);
		experienceMatcher.find(difficultyMatcher.end());
		String experienceString = profileString.substring(experienceMatcher.start(), experienceMatcher.end());
		experienceString = experienceString.substring(12, experienceString.length()-1);
		int experienceInt = Integer.valueOf(experienceString);
		//System.out.println("newParsedInt:experience: "+experienceInt);

	}

}