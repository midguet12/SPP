package domain;

public class Project {
    private int id;
    private String name;
    private String description;
    private String responsabilities;
    private String activities;
    private int duration;
    private String generalObjetive;
    private String metodologie;
    private String resources;
    private int idManajer;
    private int idOrganization;

    public Project(int id, String name, String description, String responsabilities, String activities, int duration, String generalObjetive, String metodologie, String resources, int idManajer, int idOrganization) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.responsabilities = responsabilities;
        this.activities = activities;
        this.duration = duration;
        this.generalObjetive = generalObjetive;
        this.metodologie = metodologie;
        this.resources = resources;
        this.idManajer = idManajer;
        this.idOrganization = idOrganization;
    }

    public Project(int id, String name) {
        this.id = id;
        this.name = name;
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

    public String getMetodologie() {
        return metodologie;
    }

    public void setMetodologie(String metodologie) {
        this.metodologie = metodologie;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public int getIdManajer() {
        return idManajer;
    }

    public void setIdManajer(int idManajer) {
        this.idManajer = idManajer;
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    @Override
    public String toString() {
        return "Project{" + "id=" + id + ", name=" + name + ", description=" + description + ", responsabilities=" + responsabilities + ", activities=" + activities + ", duration=" + duration + ", generalObjetive=" + generalObjetive + ", metodologie=" + metodologie + ", resources=" + resources + ", idManajer=" + idManajer + ", idOrganization=" + idOrganization + '}';
    }
    
}
