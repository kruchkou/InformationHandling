package by.epamte.infohandler.service;

import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.Text;

import java.util.List;

public interface TextService {

    Text text() throws DAOException;

    Text getSortedBySizeText(Text text);

    Text getSortedByVowelPercentageWordsList(Text text);

    String textToString(Text text);
}
