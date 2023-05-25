package lesson6;

import lesson6.logger.Decorator;
// import Seminar_7.logger.LoggerAble;
import lesson6.logger.LoggerTerminal;
import lesson6.controllers.UserController;
import lesson6.model.FileOperation;
import lesson6.model.FileOperationImpl;
import lesson6.model.Repository;
import lesson6.model.RepositoryFile;
import lesson6.utils.Validate;
import lesson6.views.ViewUser;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperationImpl("C:/Users/user/Desktop/lesson6/users.txt");
        // Repository repository = new RepositoryFile(fileOperation);
        Repository repository = new Decorator(new RepositoryFile(fileOperation), new LoggerTerminal());
        Validate validate = new Validate();
        UserController controller = new UserController(repository, validate);
        ViewUser view = new ViewUser(controller, validate);

        view.run();
    }
}
