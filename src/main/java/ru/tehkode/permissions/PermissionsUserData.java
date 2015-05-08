
package ru.tehkode.permissions;

/** This interface is currently empty, but remains to support user-specific data requirements.
 * Ideally there should be a minimal amount of data types only supported for users */
public interface PermissionsUserData extends PermissionsData {
	/** Sets the name of the user If a user already exists with this name, nothing will
	 * happen. Only supported for users because of simpler inheritance structure
	 * 
	 * @param name New name
	 * @return Whether operation was successful */
	public boolean setName(String name);
}
