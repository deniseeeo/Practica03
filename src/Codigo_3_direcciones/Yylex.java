package Codigo_3_direcciones;
import Analizador.*;
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
		/* 45 */ YY_NOT_ACCEPT,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NOT_ACCEPT,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NOT_ACCEPT,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NOT_ACCEPT,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NOT_ACCEPT,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NOT_ACCEPT,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NOT_ACCEPT,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NOT_ACCEPT,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NOT_ACCEPT,
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
		/* 102 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,130,
"50:8,26,28,25,50:21,27,41,48,51,29,46,47,50,30,31,45,43,50,44,21,42,20:10,3" +
"7,36,38,40,39,50:2,23:26,32,49,33,50,24,50,15,14,3,18,6,19,23,12,1,23,16,13" +
",23,2,17,8,23,4,5,7,9,23,11,10,23:2,34,22,35,50:2,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,103,
"0,1,2,3,4,1:10,5,6,1:6,7,8,1,9,1:5,8:2,10,8:10,11,8,9,12,13,14,15,16,17,18," +
"13,19,10,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41," +
"42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64")[0];

	private int yy_nxt[][] = unpackFromString(65,52,
"1,2,46,102,97,71,83,46,84,46:2,91,46:2,92,46:3,100,72,3,-1,45,46,-1,4,5,47:" +
"2,6,7,8,9,10,11,12,13,14,15,16,50,17,18,19,20,21,22,53,55,-1:2,23,-1:53,46," +
"73,46:16,24,46,-1:2,46:2,-1:47,3,57,-1:55,4,-1:66,27,-1:51,28,-1:12,23:24,-" +
"1,23:22,-1,48,23:2,-1,46:20,-1:2,46:2,-1:54,26:2,-1:43,34,-1,34,-1:4,34,-1:" +
"46,25,-1:30,23:24,65,52:3,23:20,48,23:2,-1,55:24,-1,55:22,31,59,55:2,-1:40," +
"29,-1:12,46:6,32,46:13,-1:2,46:2,-1:28,23:24,65,52:3,23:19,-1,48,23:2,-1:47" +
",30,-1:5,46:3,33,46:16,-1:2,46:2,-1:28,46:3,35,46:16,-1:2,46:2,-1:28,46:3,3" +
"6,46:16,-1:2,46:2,-1:28,55:24,61,63:3,55:19,49,59,55:2,-1,46:5,37,46:14,-1:" +
"2,46:2,-1:52,61:4,-1:20,55,-1:3,46:4,38,46:15,-1:2,46:2,-1:28,55:24,61,63:3" +
",55:19,31,59,55:2,-1,46:5,39,46:14,-1:2,46:2,-1:52,65:4,-1:20,23,-1:3,46:15" +
",40,46:4,-1:2,46:2,-1:28,46,41,46:18,-1:2,46:2,-1:28,46:11,42,46:8,-1:2,46:" +
"2,-1:28,46:6,43,46:13,-1:2,46:2,-1:28,46:5,44,46:14,-1:2,46:2,-1:28,46:5,51" +
",46:4,94,46:9,-1:2,46:2,-1:28,46:16,54,46:3,-1:2,46:2,-1:28,46:2,56,46:17,-" +
"1:2,46:2,-1:28,46:7,58,46:12,-1:2,46:2,-1:28,46:4,60,46:15,-1:2,46:2,-1:28," +
"46:6,62,46:13,-1:2,46:2,-1:28,46:12,64,46:7,-1:2,46:2,-1:28,46:14,66,46:5,-" +
"1:2,46:2,-1:28,46:3,67,46:16,-1:2,46:2,-1:28,46:2,68,46:17,-1:2,46:2,-1:28," +
"46:12,69,46:7,-1:2,46:2,-1:28,46:8,70,46:11,-1:2,46:2,-1:28,46:9,74,46:2,75" +
",46:7,-1:2,46:2,-1:28,46:8,76,46:11,-1:2,46:2,-1:28,77,46:19,-1:2,46:2,-1:2" +
"8,46:5,78,46:14,-1:2,46:2,-1:28,46:8,79,46:11,-1:2,46:2,-1:28,46:6,80,46:13" +
",-1:2,46:2,-1:28,46:8,81,46:11,-1:2,46:2,-1:28,46,82,46:18,-1:2,46:2,-1:28," +
"46:11,85,46:8,-1:2,46:2,-1:28,46:3,86,46:16,-1:2,46:2,-1:28,46:6,87,46:13,-" +
"1:2,46:2,-1:28,88,46:19,-1:2,46:2,-1:28,46:14,89,46:5,-1:2,46:2,-1:28,90,46" +
":19,-1:2,46:2,-1:28,46:5,93,46:14,-1:2,46:2,-1:28,46:18,95,46,-1:2,46:2,-1:" +
"28,46:6,96,46:13,-1:2,46:2,-1:28,46:5,98,46:14,-1:2,46:2,-1:28,46,99,46:18," +
"-1:2,46:2,-1:28,46:16,101,46:3,-1:2,46:2,-1:27");

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
						{ /* IGNORAR */}
					case -5:
						break;
					case 5:
						{ /* IGNORAR */}
					case -6:
						break;
					case 6:
						{ return new Symbol(sym.IDE,yyline,yychar, yytext());}
					case -7:
						break;
					case 7:
						{ return new Symbol(sym.PARIZQ,yyline,yychar, yytext());}
					case -8:
						break;
					case 8:
						{ return new Symbol(sym.PARDER,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{ return new Symbol(sym.CORCIZQ,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{ return new Symbol(sym.CORCDER,yyline,yychar, yytext());}
					case -11:
						break;
					case 11:
						{ return new Symbol (sym.LLAVEA	,yyline,yychar, yytext());}
					case -12:
						break;
					case 12:
						{ return (new Symbol(sym.LLAVEC	,yyline,yychar, yytext()));}
					case -13:
						break;
					case 13:
						{ return new Symbol(sym.PC,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{ return new Symbol(sym.DP,yyline,yychar, yytext());}
					case -15:
						break;
					case 15:
						{ return (new Symbol(sym.MENOR,yyline,yychar, yytext()));}
					case -16:
						break;
					case 16:
						{ return (new Symbol(sym.MAYOR,yyline,yychar, yytext()));}
					case -17:
						break;
					case 17:
						{ return (new Symbol(sym.DIFERENCIA,yyline,yychar, yytext()));}
					case -18:
						break;
					case 18:
						{ return (new Symbol(sym.DIVISION,yyline,yychar, yytext()));}
					case -19:
						break;
					case 19:
						{ return (new Symbol(sym.MAS,yyline,yychar, yytext()));}
					case -20:
						break;
					case 20:
						{ return (new Symbol(sym.MENOS,yyline,yychar, yytext()));}
					case -21:
						break;
					case 21:
						{ return (new Symbol(sym.MULTIPLICACION,yyline,yychar, yytext()));}
					case -22:
						break;
					case 22:
						{ return (new Symbol(sym.PORCENTAJE,yyline,yychar, yytext()));}
					case -23:
						break;
					case 23:
						{
	String string =  yytext().substring(1,yytext().length());
        return (new Symbol(sym.COMENTARIO,yyline,yychar, yytext()));
}
					case -24:
						break;
					case 24:
						{ return (new Symbol(sym.IF,yyline,yychar, yytext()));}
					case -25:
						break;
					case 25:
						{ return (new Symbol(sym.OR,yyline,yychar, yytext()));}
					case -26:
						break;
					case 26:
						{ /* IGNORAR */}
					case -27:
						break;
					case 27:
						{ return (new Symbol(sym.MENORIGUAL,yyline,yychar, yytext()));}
					case -28:
						break;
					case 28:
						{ return (new Symbol(sym.MAYORIGUAL,yyline,yychar, yytext()));}
					case -29:
						break;
					case 29:
						{ return (new Symbol(sym.IGUAL,yyline,yychar, yytext()));}
					case -30:
						break;
					case 30:
						{ return (new Symbol(sym.AND,yyline,yychar, yytext()));}
					case -31:
						break;
					case 31:
						{
	String string =  yytext().substring(1,yytext().length() - 1);
        return (new Symbol(sym.AGRUPACION,yyline,yychar, yytext()));
}
					case -32:
						break;
					case 32:
						{ return (new Symbol(sym.SET,yyline,yychar, yytext()));}
					case -33:
						break;
					case 33:
						{ return (new Symbol(sym.FOR,yyline,yychar, yytext()));}
					case -34:
						break;
					case 34:
						{ return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}
					case -35:
						break;
					case 35:
						{ return (new Symbol(sym.INCR,yyline,yychar, yytext()));}
					case -36:
						break;
					case 36:
						{ return (new Symbol(sym.EXPR,yyline,yychar, yytext()));}
					case -37:
						break;
					case 37:
						{ return (new Symbol(sym.ELSE,yyline,yychar, yytext()));}
					case -38:
						break;
					case 38:
						{ return (new Symbol(sym.PUTS,yyline,yychar, yytext()));}
					case -39:
						break;
					case 39:
						{ return (new Symbol(sym.WHILE,yyline,yychar, yytext()));}
					case -40:
						break;
					case 40:
						{ return (new Symbol(sym.BREAK,yyline,yychar, yytext()));}
					case -41:
						break;
					case 41:
						{ return (new Symbol(sym.RETURN	,yyline,yychar, yytext()));}
					case -42:
						break;
					case 42:
						{ return (new Symbol(sym.SWITCH,yyline,yychar, yytext()));}
					case -43:
						break;
					case 43:
						{ return (new Symbol(sym.DEFAULT,yyline,yychar, yytext()));}
					case -44:
						break;
					case 44:
						{ return (new Symbol(sym.CONTINUE,yyline,yychar, yytext()));}
					case -45:
						break;
					case 46:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -46:
						break;
					case 47:
						{ /* IGNORAR */}
					case -47:
						break;
					case 48:
						{
	String string =  yytext().substring(1,yytext().length());
        return (new Symbol(sym.COMENTARIO,yyline,yychar, yytext()));
}
					case -48:
						break;
					case 49:
						{
	String string =  yytext().substring(1,yytext().length() - 1);
        return (new Symbol(sym.AGRUPACION,yyline,yychar, yytext()));
}
					case -49:
						break;
					case 51:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -50:
						break;
					case 52:
						{
	String string =  yytext().substring(1,yytext().length());
        return (new Symbol(sym.COMENTARIO,yyline,yychar, yytext()));
}
					case -51:
						break;
					case 54:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -52:
						break;
					case 56:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -53:
						break;
					case 58:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -54:
						break;
					case 60:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -55:
						break;
					case 62:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -56:
						break;
					case 64:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -57:
						break;
					case 66:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -58:
						break;
					case 67:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -59:
						break;
					case 68:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -60:
						break;
					case 69:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -61:
						break;
					case 70:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -62:
						break;
					case 71:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -63:
						break;
					case 72:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -64:
						break;
					case 73:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -65:
						break;
					case 74:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -66:
						break;
					case 75:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -67:
						break;
					case 76:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -68:
						break;
					case 77:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -69:
						break;
					case 78:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -70:
						break;
					case 79:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -71:
						break;
					case 80:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -72:
						break;
					case 81:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -73:
						break;
					case 82:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -74:
						break;
					case 83:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -75:
						break;
					case 84:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -76:
						break;
					case 85:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -77:
						break;
					case 86:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -78:
						break;
					case 87:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -79:
						break;
					case 88:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -80:
						break;
					case 89:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -81:
						break;
					case 90:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -82:
						break;
					case 91:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -83:
						break;
					case 92:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -84:
						break;
					case 93:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -85:
						break;
					case 94:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -86:
						break;
					case 95:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -87:
						break;
					case 96:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -88:
						break;
					case 97:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -89:
						break;
					case 98:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -90:
						break;
					case 99:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -91:
						break;
					case 100:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -92:
						break;
					case 101:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -93:
						break;
					case 102:
						{ return new Symbol(sym.ID,yyline,yychar, new String (yytext()));}
					case -94:
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
