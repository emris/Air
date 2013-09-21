/*
 *  Copyright (C) 2013  emris
 *  https://github.com/emris/Air
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package emris.Air;

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
						world.setBlockToAir(mop.blockX, mop.blockY, mop.blockZ);
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
