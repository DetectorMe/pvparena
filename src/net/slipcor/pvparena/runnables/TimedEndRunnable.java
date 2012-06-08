package net.slipcor.pvparena.runnables;

import org.bukkit.Bukkit;

import net.slipcor.pvparena.arena.Arena;
import net.slipcor.pvparena.core.Debug;

/**
 * timed arena runnable class
 * 
 * -
 * 
 * implements an own runnable class in order to end the arena it is running in
 * 
 * @author slipcor
 * 
 * @version v0.7.0
 * 
 */

public class TimedEndRunnable implements Runnable {
	private final Arena a;
	private Debug db = new Debug(42);

	private int count = 0;
	/**
	 * create a timed arena runnable
	 * 
	 * @param a
	 *            the arena we are running in
	 */
	public TimedEndRunnable(Arena a, int i) {
		this.a = a;
		count = i+1;
		db.i("TimedEndRunnable constructor");
	}

	/**
	 * the run method, commit arena end
	 */
	@Override
	public void run() {
		TimerInfo.spam("endingexact", --count, null, a, false);
		if (count <= 0) {
			commit();
			Bukkit.getScheduler().cancelTask(a.END_ID);
			a.END_ID = -1;
			Bukkit.getScheduler().cancelTask(a.REALEND_ID);
			a.REALEND_ID = -1;
		}
	}
	
	private void commit() {
		db.i("TimedEndRunnable commiting");
		if (a.fightInProgress)
			a.type().timed();
		else {
			// deactivate the auto saving task
			Bukkit.getServer().getScheduler().cancelTask(a.END_ID);
		}
	}
}
