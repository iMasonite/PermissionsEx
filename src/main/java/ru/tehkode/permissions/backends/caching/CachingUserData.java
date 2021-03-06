
package ru.tehkode.permissions.backends.caching;

import java.util.concurrent.Executor;

import ru.tehkode.permissions.PermissionsUserData;

/** User data using a cache. */
public class CachingUserData extends CachingData implements PermissionsUserData {
	private final PermissionsUserData userData;
	
	public CachingUserData(PermissionsUserData userData, Executor executor, Object lock) {
		super(executor, lock);
		this.userData = userData;
	}
	
	@Override
	protected PermissionsUserData getBackingData() {
		return this.userData;
	}
	
	@Override
	public boolean setName(final String name) {
		execute(new Runnable() {
			@Override
			public void run() {
				getBackingData().setName(name);
			}
		});
		return true; // TODO make this more accurate
	}
}
