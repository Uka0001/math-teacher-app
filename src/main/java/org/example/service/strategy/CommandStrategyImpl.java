package org.example.service.strategy;

import java.util.Map;
import org.example.model.Command;
import org.example.service.strategy.handler.CommandHandler;
import org.example.service.strategy.handler.impl.AddEquationHandler;
import org.example.service.strategy.handler.impl.ExitCommandHandler;
import org.example.service.strategy.handler.impl.GetByRootName;
import org.example.service.strategy.handler.impl.GetByRootNumber;
import org.example.service.strategy.handler.impl.HelpCommandHandler;

public class CommandStrategyImpl implements CommandStrategy {
    private final Map<Command, CommandHandler> strategyMap;

    public CommandStrategyImpl() {
        strategyMap = Map.of(
                Command.ADD_EQUATION, new AddEquationHandler(),
                Command.GET_BY_ROOT_NAME, new GetByRootName(),
                Command.GET_BY_ROOT_NUMBER, new GetByRootNumber(),
                Command.HELP, new HelpCommandHandler(),
                Command.EXIT, new ExitCommandHandler()
        );
    }

    @Override
    public CommandHandler get(String command) {
        return strategyMap.get(Command.valueOf(command.toUpperCase()));
    }
}
