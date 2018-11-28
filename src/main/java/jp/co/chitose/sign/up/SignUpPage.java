package jp.co.chitose.sign.up;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;

public class SignUpPage extends WebPage {

    private IModel<String> emailModel;
    private IModel<String> userIdModel;
    private IModel<String> passwordModel;
    private IModel<String> typeModel;

    public SignUpPage() {

        emailModel = Model.of("");
        userIdModel = Model.of("");
        passwordModel = Model.of("");
        typeModel = Model.of("");

        Form<Void> signUpForm = new Form<Void>("form") {
            @Override
            protected void onSubmit() {
                String email = emailModel.getObject();
                String userId = userIdModel.getObject();
                String password = passwordModel.getObject();
                String type = typeModel.getObject();
                super.onSubmit();
            }
        };
        add(signUpForm);

        TextField<String> emailField = new TextField<String>("email", emailModel);
        signUpForm.add(emailField);

        TextField<String> userIdField = new TextField<>("userId", userIdModel);
        signUpForm.add(userIdField);

        TextField<String> passwordField = new TextField<>("password", passwordModel);
        signUpForm.add(passwordField);

        List<String> typeList = new ArrayList<>();
        typeList.add("教員");
        typeList.add("システム管理者");
        typeList.add("事務員");
        DropDownChoice<String> typeChoice = new DropDownChoice<>("user", typeModel, typeList);
        signUpForm.add(typeChoice);
    }
}
