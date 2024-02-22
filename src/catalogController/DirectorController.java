package catalogController;

import catalog.Area;
import catalog.Director;
import utils.Validator;

import java.util.HashSet;
import java.util.Iterator;

public class DirectorController {
    private HashSet<Director> registeredDirectors = new HashSet<>();

    public String registerDirector(String directorName, String directorCpf, String directorArea) {
        if (Validator.nullOrEmpty(directorName, directorCpf) || !Validator.fakeCpfValidator(directorCpf)) {
            return "Não foi possível realizar o cadastro do diretor, verifique as informações e tente novamente.";
        }

        Director newDirector = new Director(directorName, directorCpf, Area.valueOf(directorArea.toUpperCase()));
        if (registeredDirectors.contains(newDirector)) {
            return "CPF já está cadastrado no sistema";
        }
        registeredDirectors.add(newDirector);
        return "Diretor cadastrado com sucesso!";
    }

    public Director searchDirector(String directorCpf) {
        if (Validator.fakeCpfValidator(directorCpf)) {
            Iterator<Director> iterator = registeredDirectors.iterator();
            while (iterator.hasNext()) {
                Director director = iterator.next();
                if (director.getCpf().equals(directorCpf)) {
                    return director;
                }
            }
        }
        return null;
    }
}