package Analizador;
import java_cup.runtime.Symbol;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 128;
	private final int YY_EOF = 129;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NOT_ACCEPT,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"33:8,34,38,35,33:2,61,33:18,38,53,32,30,39,58,59,33,40,41,57,55,48,56,49,54" +
",20:10,47,46,50,52,51,33:2,21,36,26,36:3,22,36,27,36:4,29,28,25,36,23,36:2," +
"24,36:5,42,31,43,33,37,33,15,14,3,18,6,19,36,12,1,36,16,13,36,2,17,8,36,4,5" +
",7,9,36,11,10,36:2,44,60,45,33:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,109,
"0,1,2,3,4,1:2,5,1:11,6,7,1:6,8,9,10,1:5,9:13,11,9,12,13,10,14,15,16,17,18,1" +
"9,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,4" +
"4,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,6" +
"9")[0];

	private int yy_nxt[][] = unpackFromString(70,62,
"1,2,49,105,98,69,82,49,83,49:2,91,49:2,92,49:3,102,70,3,108,49:8,4,5:3,6,7," +
"49,5,52,8,9,10,11,12,13,14,15,16,17,18,19,20,51,21,22,23,24,25,26,55,57,27," +
"-1:63,49,71,49:16,28,49:10,-1:6,49:2,-1:44,3,-1:42,4:30,50,-1,4:2,-1,4:26,-" +
"1:35,7,-1:78,30,-1:61,31,-1:47,27,-1:22,27,-1,49:29,-1:6,49:2,-1:62,29,-1:2" +
"2,27,-1:31,4,-1:2,48:2,-1:2,48,-1:24,4:30,50,4:2,54,48,4:2,54,4:23,-1:52,32" +
",-1:10,49:6,35,49:22,-1:6,49:2,-1:25,4:30,50,-1,4,54,48,4:2,54,4:23,-1:59,3" +
"3,-1:3,49:3,36,49:25,-1:6,49:2,-1:84,34,-1:2,49:3,37,49:25,-1:6,49:2,-1:25," +
"49:3,38,49:25,-1:6,49:2,-1:25,49:5,39,49:23,-1:6,49:2,-1:25,49:4,40,49:24,-" +
"1:6,49:2,-1:25,49:5,41,49:23,-1:6,49:2,-1:25,49:15,42,49:13,-1:6,49:2,-1:25" +
",49,43,49:27,-1:6,49:2,-1:25,49:11,44,49:17,-1:6,49:2,-1:25,49:6,45,49:22,-" +
"1:6,49:2,-1:25,49:5,46,49:23,-1:6,49:2,-1:25,49:28,47,-1:6,49:2,-1:25,49:5," +
"53,49:4,94,49:18,-1:6,49:2,-1:25,49:16,56,49:12,-1:6,49:2,-1:25,49:2,58,49:" +
"26,-1:6,49:2,-1:25,49:7,59,49:21,-1:6,49:2,-1:25,49:4,60,49:24,-1:6,49:2,-1" +
":25,49:6,61,49:22,-1:6,49:2,-1:25,49:12,62,49:16,-1:6,49:2,-1:25,49:14,63,4" +
"9:14,-1:6,49:2,-1:25,49:3,64,49:25,-1:6,49:2,-1:25,49:2,65,49:26,-1:6,49:2," +
"-1:25,49:12,66,49:16,-1:6,49:2,-1:25,49:8,67,49:20,-1:6,49:2,-1:25,49:27,68" +
",49,-1:6,49:2,-1:25,49:9,72,49:2,73,49:16,-1:6,49:2,-1:25,49:8,74,49:20,-1:" +
"6,49:2,-1:25,75,49:28,-1:6,49:2,-1:25,49:5,76,49:23,-1:6,49:2,-1:25,49:8,77" +
",49:20,-1:6,49:2,-1:25,49:6,78,49:22,-1:6,49:2,-1:25,49:8,79,49:20,-1:6,49:" +
"2,-1:25,49,80,49:27,-1:6,49:2,-1:25,49:26,81,49:2,-1:6,49:2,-1:25,49:11,84," +
"49:17,-1:6,49:2,-1:25,49:3,85,49:25,-1:6,49:2,-1:25,49:6,86,49:22,-1:6,49:2" +
",-1:25,87,49:28,-1:6,49:2,-1:25,49:14,88,49:14,-1:6,49:2,-1:25,89,49:28,-1:" +
"6,49:2,-1:25,49:25,90,49:3,-1:6,49:2,-1:25,49:5,93,49:23,-1:6,49:2,-1:25,49" +
":18,95,49:10,-1:6,49:2,-1:25,49:6,96,49:22,-1:6,49:2,-1:25,49:20,97,49:8,-1" +
":6,49:2,-1:25,49:5,99,49:23,-1:6,49:2,-1:25,49,100,49:27,-1:6,49:2,-1:25,49" +
":24,101,49:4,-1:6,49:2,-1:25,49:16,103,49:12,-1:6,49:2,-1:25,49:23,104,49:5" +
",-1:6,49:2,-1:25,49:22,106,49:6,-1:6,49:2,-1:25,49:21,107,49:7,-1:6,49:2,-1" +
":24");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -3:
						break;
					case 3:
						{ return new Symbol(sym.NUM,yyline,yychar, yytext());}
					case -4:
						break;
					case 4:
						{
	String string =  yytext().substring(1,yytext().length());
        return (new Symbol(sym.COMENTARIO,yyline,yychar, yytext()));
}
					case -5:
						break;
					case 5:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -6:
						break;
					case 6:
						{ /* IGNORAR */}
					case -7:
						break;
					case 7:
						{ /* IGNORAR */}
					case -8:
						break;
					case 8:
						{ return new Symbol(sym.IDE,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{ return new Symbol(sym.PARIZQ,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{ return new Symbol(sym.PARDER,yyline,yychar, yytext());}
					case -11:
						break;
					case 11:
						{ return new Symbol(sym.CORCIZQ,yyline,yychar, yytext());}
					case -12:
						break;
					case 12:
						{ return new Symbol(sym.CORCDER,yyline,yychar, yytext());}
					case -13:
						break;
					case 13:
						{ return new Symbol (sym.LLAVEA	,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{ return (new Symbol(sym.LLAVEC	,yyline,yychar, yytext()));}
					case -15:
						break;
					case 15:
						{ return new Symbol(sym.PC,yyline,yychar, yytext());}
					case -16:
						break;
					case 16:
						{ return new Symbol(sym.DP,yyline,yychar, yytext());}
					case -17:
						break;
					case 17:
						{ return new Symbol(sym.COMA,yyline,yychar, yytext());}
					case -18:
						break;
					case 18:
						{ return new Symbol(sym.PUNTO,yyline,yychar, yytext());}
					case -19:
						break;
					case 19:
						{ return (new Symbol(sym.MENOR,yyline,yychar, yytext()));}
					case -20:
						break;
					case 20:
						{ return (new Symbol(sym.MAYOR,yyline,yychar, yytext()));}
					case -21:
						break;
					case 21:
						{ return (new Symbol(sym.DIFERENCIA,yyline,yychar, yytext()));}
					case -22:
						break;
					case 22:
						{ return (new Symbol(sym.DIVISION,yyline,yychar, yytext()));}
					case -23:
						break;
					case 23:
						{ return (new Symbol(sym.MAS,yyline,yychar, yytext()));}
					case -24:
						break;
					case 24:
						{ return (new Symbol(sym.MENOS,yyline,yychar, yytext()));}
					case -25:
						break;
					case 25:
						{ return (new Symbol(sym.MULTIPLICACION,yyline,yychar, yytext()));}
					case -26:
						break;
					case 26:
						{ return (new Symbol(sym.PORCENTAJE,yyline,yychar, yytext()));}
					case -27:
						break;
					case 27:
						{ }
					case -28:
						break;
					case 28:
						{ return (new Symbol(sym.IF,yyline,yychar, yytext()));}
					case -29:
						break;
					case 29:
						{ /* IGNORAR */}
					case -30:
						break;
					case 30:
						{ return (new Symbol(sym.MENORIGUAL,yyline,yychar, yytext()));}
					case -31:
						break;
					case 31:
						{ return (new Symbol(sym.MAYORIGUAL,yyline,yychar, yytext()));}
					case -32:
						break;
					case 32:
						{ return (new Symbol(sym.IGUAL,yyline,yychar, yytext()));}
					case -33:
						break;
					case 33:
						{ return (new Symbol(sym.AND,yyline,yychar, yytext()));}
					case -34:
						break;
					case 34:
						{ return (new Symbol(sym.OR,yyline,yychar, yytext()));}
					case -35:
						break;
					case 35:
						{ return (new Symbol(sym.SET,yyline,yychar, yytext()));}
					case -36:
						break;
					case 36:
						{ return (new Symbol(sym.FOR,yyline,yychar, yytext()));}
					case -37:
						break;
					case 37:
						{ return (new Symbol(sym.INCR,yyline,yychar, yytext()));}
					case -38:
						break;
					case 38:
						{ return (new Symbol(sym.EXPR,yyline,yychar, yytext()));}
					case -39:
						break;
					case 39:
						{ return (new Symbol(sym.ELSE,yyline,yychar, yytext()));}
					case -40:
						break;
					case 40:
						{ return (new Symbol(sym.PUTS,yyline,yychar, yytext()));}
					case -41:
						break;
					case 41:
						{ return (new Symbol(sym.WHILE,yyline,yychar, yytext()));}
					case -42:
						break;
					case 42:
						{ return (new Symbol(sym.BREAK,yyline,yychar, yytext()));}
					case -43:
						break;
					case 43:
						{ return (new Symbol(sym.RETURN	,yyline,yychar, yytext()));}
					case -44:
						break;
					case 44:
						{ return (new Symbol(sym.SWITCH,yyline,yychar, yytext()));}
					case -45:
						break;
					case 45:
						{ return (new Symbol(sym.DEFAULT,yyline,yychar, yytext()));}
					case -46:
						break;
					case 46:
						{ return (new Symbol(sym.CONTINUE,yyline,yychar, yytext()));}
					case -47:
						break;
					case 47:
						{
	String string =  yytext().substring(1,yytext().length() - 1);
        return (new Symbol(sym.AGRUPACION,yyline,yychar, yytext()));
}
					case -48:
						break;
					case 49:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -49:
						break;
					case 50:
						{
	String string =  yytext().substring(1,yytext().length());
        return (new Symbol(sym.COMENTARIO,yyline,yychar, yytext()));
}
					case -50:
						break;
					case 51:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -51:
						break;
					case 52:
						{ /* IGNORAR */}
					case -52:
						break;
					case 53:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -53:
						break;
					case 54:
						{
	String string =  yytext().substring(1,yytext().length());
        return (new Symbol(sym.COMENTARIO,yyline,yychar, yytext()));
}
					case -54:
						break;
					case 55:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -55:
						break;
					case 56:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -56:
						break;
					case 57:
						{ 
    System.out.println("error lexico en "  + yyline + "," + yychar + " No se reconoce " + yytext());
    yychar=0;
  }
					case -57:
						break;
					case 58:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -58:
						break;
					case 59:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -59:
						break;
					case 60:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -60:
						break;
					case 61:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -61:
						break;
					case 62:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -62:
						break;
					case 63:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -63:
						break;
					case 64:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -64:
						break;
					case 65:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -65:
						break;
					case 66:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -66:
						break;
					case 67:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -67:
						break;
					case 68:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -68:
						break;
					case 69:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -69:
						break;
					case 70:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -70:
						break;
					case 71:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -71:
						break;
					case 72:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -72:
						break;
					case 73:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -73:
						break;
					case 74:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -74:
						break;
					case 75:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -75:
						break;
					case 76:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -76:
						break;
					case 77:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -77:
						break;
					case 78:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -78:
						break;
					case 79:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -79:
						break;
					case 80:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -80:
						break;
					case 81:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -81:
						break;
					case 82:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -82:
						break;
					case 83:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -83:
						break;
					case 84:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -84:
						break;
					case 85:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -85:
						break;
					case 86:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -86:
						break;
					case 87:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -87:
						break;
					case 88:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -88:
						break;
					case 89:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -89:
						break;
					case 90:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -90:
						break;
					case 91:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -91:
						break;
					case 92:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -92:
						break;
					case 93:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -93:
						break;
					case 94:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -94:
						break;
					case 95:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -95:
						break;
					case 96:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -96:
						break;
					case 97:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -97:
						break;
					case 98:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -98:
						break;
					case 99:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -99:
						break;
					case 100:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -100:
						break;
					case 101:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -101:
						break;
					case 102:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -102:
						break;
					case 103:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -103:
						break;
					case 104:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -104:
						break;
					case 105:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -105:
						break;
					case 106:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -106:
						break;
					case 107:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -107:
						break;
					case 108:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -108:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
