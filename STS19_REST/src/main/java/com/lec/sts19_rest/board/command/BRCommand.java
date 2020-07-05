package com.lec.sts19_rest.board.command;

import org.springframework.ui.Model;

public interface BRCommand {
	public abstract void execute(Model model);
}
