package net.KingTux.JoinLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinLogger extends JavaPlugin implements Listener {

	public static File file;

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new Events(), this);
		file = new File(getDataFolder() + "/JoinExit.log");
		try {

			if (!getDataFolder().exists()) {
				getDataFolder().mkdirs();
			}

			if (!file.exists()) {

				file.createNewFile();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onDisable() {

	}

	public static void SaveFile(String Job, Player p) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		if (Job.equalsIgnoreCase("exit")) {
			System.out.println("[JoinLogger] " + p.getName().toString() + " Exited");

			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
				bw.write(p.getName().toString() + " Exited at " + dateFormat.format(date));
				bw.newLine();
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else if (Job.equalsIgnoreCase("login")) {
			System.out.println("[JoinLogger] " + p.getName().toString() + " Joined");

			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
				bw.write(p.getName().toString() + " Joined at " + dateFormat.format(date));
				bw.newLine();
				bw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			System.out.println("You failed WYATT");
		}

	}

}
