package com.cooksys.ftd.assignments.collections.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TODO: Implement this class <br>
 * <br>
 * A worker is a type of employee that cannot be a superior to another employee.
 * <br>
 * A worker should have a name, and, optionally, a manager superior to them.
 */
public class Worker implements Employee {

	// TODO: Does this class need private fields? If so, add them here
	// * ADD FIELDS
	private String name;
	private Manager manager;

	/**
	 * TODO: Implement this constructor.
	 *
	 * @param name the name of the worker to be created
	 */
	public Worker(String name) {
		this.name = name;
	}

	/**
	 * TODO: Implement this constructor.
	 *
	 * @param name    the name of the worker to be created
	 * @param manager the direct manager of the worker to be created
	 */
	public Worker(String name, Manager manager) {
		this.name = name;
		this.manager = manager;
	}

	/**
	 * TODO: Implement this getter.
	 *
	 * @return the name of the worker
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * TODO: Implement this getter.
	 *
	 * @return {@code true} if this worker has a manager, or {@code false} otherwise
	 */
	@Override
	public boolean hasManager() {
		if (manager != null) {
			return true;
		} else
			return false;
	}

	/**
	 * TODO: Implement this getter.
	 *
	 * @return the manager of this worker, or null if it has none
	 */
	@Override
	public Manager getManager() {
		return manager;
	}

	/**
	 * TODO: Implement this method. <br>
	 * <br>
	 * Retrieves the worker's chain of command as a {@code List<Manager>}, starting
	 * with their direct {@code Manager}, followed by that {@code Manager}'s
	 * {@code Manager}, and so on, until the top of the hierarchy is reached. <br>
	 * <br>
	 * The returned list should never be or contain {@code null}. <br>
	 * <br>
	 * If the worker does not have a {@code Manager}, an empty {@code List<Manager>}
	 * should be returned.
	 *
	 * @return a {@code List<Manager>} that represents the worker's chain of
	 *         command,
	 */
	@Override

	public List<Manager> getChainOfCommand() {
		List<Manager> chainOfCommand = new ArrayList<>();
		Manager m = getManager();
		while (hasManager() && m != null) {
			chainOfCommand.add(m);
			m = m.getManager();
		}

		return chainOfCommand;
	}
//   (FOR REVIEW)
//    for (Manager m = manager; m != null; m = m.getManager()) {
//        chainOfCommand.add(m);
//    }

//	public void setManager(Manager manager) {
//		this.manager = manager;
//	}

	// TODO: Does this class need custom .equals() and .hashcode() methods? If so,
	// implement them here.

	// TODO [OPTIONAL]: Consider adding a custom .toString() method here if you want
	// to debug your code with System.out.println() statements

	@Override
	public int hashCode() {
		return Objects.hash(manager, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Worker other = (Worker) obj;
		return Objects.equals(manager, other.manager) && Objects.equals(name, other.name);
	}

}
