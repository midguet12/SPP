package domain;

public class Project {
    private int id;
    private String name;
    private String description;
    private String responsabilities;
    private String activities;
    private int duration;
    private String generalObjetive;
    private String metodology;
    private String resources;
    private int idManager;
    private int idOrganization;
    
    public Project(String name, String description, String responsabilities, String activities, int duration, String generalObjetive, String metodology, String resources, int idManager, int idOrganization) {
        
        this.name = name;
        this.description = description;
        this.responsabilities = responsabilities;
        this.activities = activities;
        this.duration = duration;
        this.generalObjetive = generalObjetive;
        this.metodology = metodology;
        this.resources = resources;
        this.idManager = idManager;
        this.idOrganization = idOrganization;
    }


    public Project(int id, String name, String description, String responsabilities, String activities, int duration, String generalObjetive, String metodology, String resources, int idManager, int idOrganization) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.responsabilities = responsabilities;
        this.activities = activities;
        this.duration = duration;
        this.generalObjetive = generalObjetive;
        this.metodology = metodology;
        this.resources = resources;
        this.idManager = idManager;
        this.idOrganization = idOrganization;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResponsabilities() {
        return responsabilities;
    }

    public void setResponsabilities(String responsabilities) {
        this.responsabilities = responsabilities;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGeneralObjetive() {
        return generalObjetive;
    }

    public void setGeneralObjetive(String generalObjetive) {
        this.generalObjetive = generalObjetive;
    }

    public String getMetodology() {
        return metodology;
    }

    public void setMetodology(String metodologie) {
        this.metodology = metodologie;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", description=" + description + ", responsabilities=" + responsabilities + ", activities=" + activities + ", duration=" + duration + ", generalObjetive=" + generalObjetive + ", metodologie=" + metodology + ", resources=" + resources + ", idManajer=" + idManager + ", idOrganization=" + idOrganization + '}';
    }
    
}
