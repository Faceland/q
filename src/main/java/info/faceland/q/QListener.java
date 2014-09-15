package info.faceland.q;

import info.faceland.q.QPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class QListener implements Listener {

    private QPlugin plugin;

    public QListener(QPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerCommandPreProcess(PlayerCommandPreprocessEvent event) {
        if (event.isCancelled()) {
            return;
        }
        String cmd = event.getMessage().substring(1);
        Player player = event.getPlayer();
        try {
            Runnable reaction = plugin.getQuestionManager().answerFirstQuestion(player.getUniqueId(), cmd);
            int id = plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, reaction);
            if (id == -1) {
                return;
            }
            plugin.getQuestionManager().removeFirstQuestion(player.getUniqueId());
            event.setCancelled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
