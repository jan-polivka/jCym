package business_logic;

import java.util.HashMap;
import java.util.List;

public class Cleric {

    HashMap<String, String> abilityScores;

    public Cleric() {
    }

    public void assignAbilityScore(List<Integer> scores) {
        abilityScores.put("STR", scores.get(0).toString());
        abilityScores.put("INT", scores.get(1).toString());
        abilityScores.put("WIS", scores.get(2).toString());
        abilityScores.put("DEX", scores.get(3).toString());
        abilityScores.put("CON", scores.get(4).toString());
        abilityScores.put("CHA", scores.get(5).toString());
    }
}
