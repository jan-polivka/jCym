package business_logic;

import interfaces.Inputter;
import interfaces.Outputter;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RandomAbilityScoreRollerTest {

    @Mock
    Outputter outputter;
    @Mock
    Inputter inputter;
    RandomAbilityScoreRoller roller = new RandomAbilityScoreRoller(inputter, outputter);

    @org.junit.jupiter.api.Test
    void rejectAbilityScores() {
        var scores = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));

        var res = roller.confirmReasonableAbilityScores(scores);

        assertFalse(res);
    }

    @org.junit.jupiter.api.Test
    void confirmAbilityScores() {
        var scores = new ArrayList<Integer>(Arrays.asList(6,6,9,9,9,9));

        var res = roller.confirmReasonableAbilityScores(scores);

        assertTrue(res);
    }
}