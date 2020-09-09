package by.epamte.infohandler.service.impl;

import by.epamte.infohandler.dao.DAOFactory;
import by.epamte.infohandler.dao.TextDAO;
import by.epamte.infohandler.dao.exception.DAOException;
import by.epamte.infohandler.entity.TextElement;
import by.epamte.infohandler.entity.impl.Text;
import by.epamte.infohandler.service.TextService;
import by.epamte.infohandler.util.TextToStringUtil;
import by.epamte.infohandler.util.UtilFactory;
import by.epamte.infohandler.util.SortBySizeUtil;
import by.epamte.infohandler.util.SortByVowelPercentageUtil;

import java.util.List;

public class TextServiceImpl implements TextService {

    private final UtilFactory utilFactory = UtilFactory.getInstance();

    @Override
    public Text text() throws DAOException {

        DAOFactory factory = DAOFactory.getInstance();
        TextDAO textDAO = factory.textDAO();

        return textDAO.text();
    }

    public Text getSortedBySizeText(Text text) {
        SortBySizeUtil sortBySizeUtil = utilFactory.getSortBySizeUtil();

        return sortBySizeUtil.process(text);
    }

    @Override
    public Text getSortedByVowelPercentageWordsList(Text text) {
        SortByVowelPercentageUtil sortByVowelPercentageUtil = utilFactory.getSortByVowelPercentageUtil();

        return sortByVowelPercentageUtil.process(text);
    }

    @Override
    public String textToString(Text text) {
        TextToStringUtil textToStringUtil = utilFactory.getGetTextToStringUtil();

        return textToStringUtil.process(text);
    }


}
