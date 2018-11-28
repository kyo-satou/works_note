package jp.co.chitose;

import com.giffing.wicket.spring.boot.context.scan.WicketHomePage;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

@WicketHomePage
public class HomePage extends WebPage {
    public HomePage() {
        Link<Void> toSignUpPageLink = new Link<Void>("toSignUpPage") {
            @Override
            public void onClick() {
                setResponsePage(SignUpPage.class);
            }
        };
        add(toSignUpPageLink);

        String label = "Sign Up Page";
        IModel<String> model = Model.of(label);
        Label signUpLabel = new Label("label", model);
        toSignUpPageLink.add(signUpLabel);
    }
}
