package org.example.service.strategy;

import org.example.service.strategy.handler.CommandHandler;
import org.example.service.strategy.handler.impl.AddEquationHandler;
import org.example.service.strategy.handler.impl.ExitCommandHandler;
import org.example.service.strategy.handler.impl.GetByRootName;
import org.example.service.strategy.handler.impl.GetByRootNumber;
import org.example.service.strategy.handler.impl.HelpCommandHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommandStrategyImplTest {
    CommandStrategy commandStrategy;

    @BeforeEach
    void setUp() {
        commandStrategy = new CommandStrategyImpl();
    }

    @Test
    void get_ok() {
        CommandHandler addCommandHandler = commandStrategy.get("add_equation");
        Assertions.assertEquals(new AddEquationHandler().getClass(),
                addCommandHandler.getClass(),
                "Should return proper handler: " + addCommandHandler);
        CommandHandler getNameCommandHandler = commandStrategy.get("get_by_root_name");
        Assertions.assertEquals(new GetByRootName().getClass(),
                getNameCommandHandler.getClass(),
                "Should return proper handler: " + getNameCommandHandler);
        CommandHandler getNumberCommandHandler = commandStrategy.get("get_by_root_number");
        Assertions.assertEquals(new GetByRootNumber().getClass(),
                getNumberCommandHandler.getClass(),
                "Should return proper handler: " + getNumberCommandHandler);
        CommandHandler helpCommandHandler = commandStrategy.get("help");
        Assertions.assertEquals(new HelpCommandHandler().getClass(),
                helpCommandHandler.getClass(),
                "Should return proper handler: " + helpCommandHandler);
        CommandHandler exitCommandHandler = commandStrategy.get("exit");
        Assertions.assertEquals(new ExitCommandHandler().getClass(),
                exitCommandHandler.getClass(),
                "Should return proper handler: " + exitCommandHandler);

    }

    @Test
    void get_emptyCommand_notOk() {
        IllegalArgumentException thrown
                = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            commandStrategy.get("");
        });
        Assertions.assertEquals("No enum constant org.example.model.Command.",
                thrown.getMessage(),
                "Should throw exception: \" java.lang.IllegalArgumentException:"
                        + " No enum constant org.example.model.Command.\"");
    }

    @Test
    void get_nullCommand_notOk() {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            commandStrategy.get(null);
        });
        Assertions.assertEquals("Cannot invoke \"String.toUpperCase()\" because \"command\" is null",
                thrown.getMessage(),
                "Should throw exception: \" NullPointerException:"
                        + " Cannot invoke \"String.toUpperCase()\" because \"command\" is null\"");
    }

    @Test
    void get_notValidCommand_notOk() {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            commandStrategy.get("notValidCommand");
        });
        Assertions.assertEquals("No enum constant org.example.model.Command.NOTVALIDCOMMAND",
                thrown.getMessage(),
                "Should throw exception: \" java.lang.IllegalArgumentException:"
                        + " No enum constant org.example.model.Command.\"");
    }
}