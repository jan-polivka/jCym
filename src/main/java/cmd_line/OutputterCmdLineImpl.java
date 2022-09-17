package cmd_line;

import interfaces.Outputter;

public class OutputterCmdLineImpl implements Outputter {

    public OutputterCmdLineImpl() {
    }

    @Override
    public void outputString(String message) {
        System.out.println(message);
    }
}
