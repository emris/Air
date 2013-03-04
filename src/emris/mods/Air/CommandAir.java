package emris.mods.Air;

import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class CommandAir extends CommandBase {

	@Override
	public String getCommandName() {
		return "air";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/" + getCommandName() + " => Turns Block you are looking at into Air.";
	}

	@Override
	public List getCommandAliases() {
		return null;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] args) {
		if (sender instanceof EntityPlayerMP) {
			EntityPlayerMP curPlayer = (EntityPlayerMP) sender;
			MovingObjectPosition mop = PlayerUtils.getTargetBlock(curPlayer);
			if (mop != null) {
				if (mop.typeOfHit == EnumMovingObjectType.TILE) {
					World world = curPlayer.worldObj;
					int bID = world.getBlockId(mop.blockX, mop.blockY, mop.blockZ);
					if (bID > 0) {
						world.setBlockWithNotify(mop.blockX, mop.blockY, mop.blockZ, 0);
					}
				}
			}
			
		}

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender sender) {
		if (sender instanceof EntityPlayerMP) {
			return true;
		} else {
			return false;
		}
	}
}
