package business_logic;

import interfaces.Inputter;
import interfaces.Outputter;

import java.util.*;
import java.util.stream.Collectors;

public class RandomAbilityScoreRoller {

    private Inputter inputter;
    private Outputter outputter;

    public RandomAbilityScoreRoller(Inputter inputter, Outputter outputter){
        this.inputter = inputter;
        this.outputter = outputter;
    }

    public String chooseAlignment(){
        outputter.outputString("Select your alignment");
        outputter.outputString("1 -  Lawful");
        outputter.outputString("2 - Neutral");
        outputter.outputString("3 - Chaotic");

        return inputter.getString();
    }

    public String chooseClass(){
        outputter.outputString("Select your class");
        outputter.outputString("1 - Cleric");

        return inputter.getString();
    }

    public String chooseName(){
        outputter.outputString("Insert your name");
        return inputter.getString();
    }

    public List<Integer> rollAbilityScore(){
        boolean reasonable = false;
        var generated = new ArrayList<Integer>();
        while(!reasonable) {
            generated = this.generateReasonableAbilityScores();
            reasonable = confirmReasonableAbilityScores(generated);
        }
        return generated;
    }

    public boolean confirmReasonableAbilityScores(ArrayList<Integer> reasonableAbilityScores) {
        if (reasonableAbilityScores.size() != 6) return false;
        var filtered = reasonableAbilityScores.stream().filter(score -> score < 9)
                .collect(Collectors.toCollection(ArrayList::new));
        if (filtered.size() < 3) return true;
        else return false;
    }

    private ArrayList<Integer> generateReasonableAbilityScores(){
        Random rnd = new Random();
        ArrayList<Integer> aS = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            aS.add(rnd.nextInt(6, 18));
        }
        return aS;
    }

    public Integer rollHitPoints(Integer upperBound, Integer conModifier){
        Random rnd = new Random();
        return rnd.nextInt(1, upperBound) + conModifier;
    }

}
