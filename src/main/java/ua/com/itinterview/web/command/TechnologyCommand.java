package ua.com.itinterview.web.command;

import ua.com.itinterview.entity.TechnologyEntity;

public class TechnologyCommand {

    private String name;

    public TechnologyCommand() {

    }

    public TechnologyCommand(TechnologyEntity entity) {
	name = entity.getTechnologyName();
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	TechnologyCommand other = (TechnologyCommand) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TechnologyCommand [name=" + name + "]";
    }

}