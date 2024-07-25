package pack.service;

import org.springframework.ui.Model;

public interface MainService {
	public void getList(Model model);
	public void findGogek(int gogek_damsano, Model model);
}
