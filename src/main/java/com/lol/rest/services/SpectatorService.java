package com.lol.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.lol.dto.CurrentGameInfoDTO;
import com.lol.interfaces.ICommonService;
import com.lol.interfaces.ISpectatorService;
import com.lol.util.LolConstants;

@Service
public class SpectatorService implements ISpectatorService{

	@Value("${lol.api.key}")
	private String apiKey;

	@Autowired
	ICommonService commonService;

	@Override
	public CurrentGameInfoDTO getCurrentGameInfo(String summonerId) {

		String request = LolConstants.SPECTATOR_CURRENTGAME_API + summonerId + "?api_key=" + apiKey;
		CurrentGameInfoDTO currentGame = (CurrentGameInfoDTO) commonService.getResponse(request,CurrentGameInfoDTO.class);
		return currentGame;

	}

}
