package catalogController;

import catalog.Actor;
import utils.Validator;

import java.util.HashSet;
import java.util.Iterator;

public class ActorController {
    private HashSet<Actor> registeredActors = new HashSet<>();

    public String registerActor(String actorName, String actorCpf) {
        if (Validator.nullOrEmpty(actorName, actorCpf) || !Validator.fakeCpfValidator(actorCpf)) {
            return "Não foi possível realizar o cadastro do ator, verifique as informações e tente novamente.";
        }
        Actor newActor = new Actor(actorName, actorCpf);
        if (registeredActors.contains(newActor)) {
            return "CPF já está cadastrado no sistema";
        }
        registeredActors.add(newActor);
        return "Ator cadastrado com sucesso!";
    }

    public Actor searchActor(String actorCpf) {
        if (Validator.fakeCpfValidator(actorCpf)) {
            Iterator<Actor> iterator = registeredActors.iterator();
            while (iterator.hasNext()) {
                Actor actor = iterator.next();
                if (actor.getCpf().equals(actorCpf)) {
                    return actor;
                }
            }
        }
        return null;
    }
}