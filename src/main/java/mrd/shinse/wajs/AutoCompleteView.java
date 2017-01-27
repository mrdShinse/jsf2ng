package mrd.shinse.wajs;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.SelectEvent;

@ManagedBean
public class AutoCompleteView {

    @Getter
    @Setter
    private String txt1;
    @Getter
    @Setter
    private String date;
    @Getter
    @Setter
    private String password1;
    @Getter
    @Setter
    private String value1;
    @Getter
    @Setter
    private String console;
    @Getter
    @Setter
    private String[] selectedCities;
    @Getter
    @Setter
    private List<String> cities;

    @PostConstruct
    public void init() {
        cities = new ArrayList<>();
        cities.add("Miami");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
    }

    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            results.add(query + i);
        }

        return results;
    }

    public void onItemSelect(SelectEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Item Selected", event.getObject().toString()));
    }

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
