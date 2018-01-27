package net.avicus.goodbye;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public final class Goodbye extends Plugin implements Listener {

  @Override
  public void onEnable() {
    PluginManager manager = getProxy().getPluginManager();
    manager.registerListener(this, new ValedictionAnnouncer());
  }
}
