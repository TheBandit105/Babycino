// Generated from babycino/MiniJava.g4 by ANTLR 4.9.1
package babycino;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MiniJavaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, INT=38, IDENT=39, 
		ALPHA=40, ALNUM=41, WS=42, COMMENT=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
			"T__33", "T__34", "T__35", "T__36", "INT", "IDENT", "ALPHA", "ALNUM", 
			"WS", "COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "'{'", "'public'", "'static'", "'void'", "'main'", "'('", 
			"'String'", "'['", "']'", "')'", "'}'", "'extends'", "';'", "','", "'return'", 
			"'int'", "'boolean'", "'if'", "'else'", "'while'", "'System.out.println'", 
			"'='", "'++'", "'.'", "'length'", "'!'", "'*'", "'+'", "'-'", "'<'", 
			"'>='", "'&&'", "'true'", "'false'", "'this'", "'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT", "IDENT", "ALPHA", "ALNUM", "WS", "COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public MiniJavaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MiniJava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0120\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3"+
		"\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%"+
		"\3%\3%\3%\3&\3&\3&\3&\3\'\6\'\u00fe\n\'\r\'\16\'\u00ff\3(\3(\7(\u0104"+
		"\n(\f(\16(\u0107\13(\3)\3)\3*\3*\5*\u010d\n*\3+\6+\u0110\n+\r+\16+\u0111"+
		"\3+\3+\3,\3,\3,\3,\7,\u011a\n,\f,\16,\u011d\13,\3,\3,\2\2-\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-\3\2\6\3\2\62;\5\2C\\aac|\5\2\13\f\17\17\"\"\4\2\f\f"+
		"\17\17\2\u0124\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2"+
		"\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\2"+
		"9\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3"+
		"\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2"+
		"\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\t"+
		"h\3\2\2\2\13o\3\2\2\2\rt\3\2\2\2\17y\3\2\2\2\21{\3\2\2\2\23\u0082\3\2"+
		"\2\2\25\u0084\3\2\2\2\27\u0086\3\2\2\2\31\u0088\3\2\2\2\33\u008a\3\2\2"+
		"\2\35\u0092\3\2\2\2\37\u0094\3\2\2\2!\u0096\3\2\2\2#\u009d\3\2\2\2%\u00a1"+
		"\3\2\2\2\'\u00a9\3\2\2\2)\u00ac\3\2\2\2+\u00b1\3\2\2\2-\u00b7\3\2\2\2"+
		"/\u00ca\3\2\2\2\61\u00cc\3\2\2\2\63\u00cf\3\2\2\2\65\u00d1\3\2\2\2\67"+
		"\u00d8\3\2\2\29\u00da\3\2\2\2;\u00dc\3\2\2\2=\u00de\3\2\2\2?\u00e0\3\2"+
		"\2\2A\u00e2\3\2\2\2C\u00e5\3\2\2\2E\u00e8\3\2\2\2G\u00ed\3\2\2\2I\u00f3"+
		"\3\2\2\2K\u00f8\3\2\2\2M\u00fd\3\2\2\2O\u0101\3\2\2\2Q\u0108\3\2\2\2S"+
		"\u010c\3\2\2\2U\u010f\3\2\2\2W\u0115\3\2\2\2YZ\7e\2\2Z[\7n\2\2[\\\7c\2"+
		"\2\\]\7u\2\2]^\7u\2\2^\4\3\2\2\2_`\7}\2\2`\6\3\2\2\2ab\7r\2\2bc\7w\2\2"+
		"cd\7d\2\2de\7n\2\2ef\7k\2\2fg\7e\2\2g\b\3\2\2\2hi\7u\2\2ij\7v\2\2jk\7"+
		"c\2\2kl\7v\2\2lm\7k\2\2mn\7e\2\2n\n\3\2\2\2op\7x\2\2pq\7q\2\2qr\7k\2\2"+
		"rs\7f\2\2s\f\3\2\2\2tu\7o\2\2uv\7c\2\2vw\7k\2\2wx\7p\2\2x\16\3\2\2\2y"+
		"z\7*\2\2z\20\3\2\2\2{|\7U\2\2|}\7v\2\2}~\7t\2\2~\177\7k\2\2\177\u0080"+
		"\7p\2\2\u0080\u0081\7i\2\2\u0081\22\3\2\2\2\u0082\u0083\7]\2\2\u0083\24"+
		"\3\2\2\2\u0084\u0085\7_\2\2\u0085\26\3\2\2\2\u0086\u0087\7+\2\2\u0087"+
		"\30\3\2\2\2\u0088\u0089\7\177\2\2\u0089\32\3\2\2\2\u008a\u008b\7g\2\2"+
		"\u008b\u008c\7z\2\2\u008c\u008d\7v\2\2\u008d\u008e\7g\2\2\u008e\u008f"+
		"\7p\2\2\u008f\u0090\7f\2\2\u0090\u0091\7u\2\2\u0091\34\3\2\2\2\u0092\u0093"+
		"\7=\2\2\u0093\36\3\2\2\2\u0094\u0095\7.\2\2\u0095 \3\2\2\2\u0096\u0097"+
		"\7t\2\2\u0097\u0098\7g\2\2\u0098\u0099\7v\2\2\u0099\u009a\7w\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7p\2\2\u009c\"\3\2\2\2\u009d\u009e\7k\2\2\u009e"+
		"\u009f\7p\2\2\u009f\u00a0\7v\2\2\u00a0$\3\2\2\2\u00a1\u00a2\7d\2\2\u00a2"+
		"\u00a3\7q\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7g\2\2"+
		"\u00a6\u00a7\7c\2\2\u00a7\u00a8\7p\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7k\2"+
		"\2\u00aa\u00ab\7h\2\2\u00ab(\3\2\2\2\u00ac\u00ad\7g\2\2\u00ad\u00ae\7"+
		"n\2\2\u00ae\u00af\7u\2\2\u00af\u00b0\7g\2\2\u00b0*\3\2\2\2\u00b1\u00b2"+
		"\7y\2\2\u00b2\u00b3\7j\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7n\2\2\u00b5"+
		"\u00b6\7g\2\2\u00b6,\3\2\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9\7{\2\2\u00b9"+
		"\u00ba\7u\2\2\u00ba\u00bb\7v\2\2\u00bb\u00bc\7g\2\2\u00bc\u00bd\7o\2\2"+
		"\u00bd\u00be\7\60\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1"+
		"\7v\2\2\u00c1\u00c2\7\60\2\2\u00c2\u00c3\7r\2\2\u00c3\u00c4\7t\2\2\u00c4"+
		"\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7n\2\2"+
		"\u00c8\u00c9\7p\2\2\u00c9.\3\2\2\2\u00ca\u00cb\7?\2\2\u00cb\60\3\2\2\2"+
		"\u00cc\u00cd\7-\2\2\u00cd\u00ce\7-\2\2\u00ce\62\3\2\2\2\u00cf\u00d0\7"+
		"\60\2\2\u00d0\64\3\2\2\2\u00d1\u00d2\7n\2\2\u00d2\u00d3\7g\2\2\u00d3\u00d4"+
		"\7p\2\2\u00d4\u00d5\7i\2\2\u00d5\u00d6\7v\2\2\u00d6\u00d7\7j\2\2\u00d7"+
		"\66\3\2\2\2\u00d8\u00d9\7#\2\2\u00d98\3\2\2\2\u00da\u00db\7,\2\2\u00db"+
		":\3\2\2\2\u00dc\u00dd\7-\2\2\u00dd<\3\2\2\2\u00de\u00df\7/\2\2\u00df>"+
		"\3\2\2\2\u00e0\u00e1\7>\2\2\u00e1@\3\2\2\2\u00e2\u00e3\7@\2\2\u00e3\u00e4"+
		"\7?\2\2\u00e4B\3\2\2\2\u00e5\u00e6\7(\2\2\u00e6\u00e7\7(\2\2\u00e7D\3"+
		"\2\2\2\u00e8\u00e9\7v\2\2\u00e9\u00ea\7t\2\2\u00ea\u00eb\7w\2\2\u00eb"+
		"\u00ec\7g\2\2\u00ecF\3\2\2\2\u00ed\u00ee\7h\2\2\u00ee\u00ef\7c\2\2\u00ef"+
		"\u00f0\7n\2\2\u00f0\u00f1\7u\2\2\u00f1\u00f2\7g\2\2\u00f2H\3\2\2\2\u00f3"+
		"\u00f4\7v\2\2\u00f4\u00f5\7j\2\2\u00f5\u00f6\7k\2\2\u00f6\u00f7\7u\2\2"+
		"\u00f7J\3\2\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7g\2\2\u00fa\u00fb\7y\2"+
		"\2\u00fbL\3\2\2\2\u00fc\u00fe\t\2\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff"+
		"\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100N\3\2\2\2\u0101"+
		"\u0105\5Q)\2\u0102\u0104\5S*\2\u0103\u0102\3\2\2\2\u0104\u0107\3\2\2\2"+
		"\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106P\3\2\2\2\u0107\u0105\3"+
		"\2\2\2\u0108\u0109\t\3\2\2\u0109R\3\2\2\2\u010a\u010d\5Q)\2\u010b\u010d"+
		"\t\2\2\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010dT\3\2\2\2\u010e"+
		"\u0110\t\4\2\2\u010f\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u010f\3\2"+
		"\2\2\u0111\u0112\3\2\2\2\u0112\u0113\3\2\2\2\u0113\u0114\b+\2\2\u0114"+
		"V\3\2\2\2\u0115\u0116\7\61\2\2\u0116\u0117\7\61\2\2\u0117\u011b\3\2\2"+
		"\2\u0118\u011a\n\5\2\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119"+
		"\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e"+
		"\u011f\b,\2\2\u011fX\3\2\2\2\b\2\u00ff\u0105\u010c\u0111\u011b\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}