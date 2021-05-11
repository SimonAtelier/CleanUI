package minigame.view;

public class MessageBuilder {

	private String last;
	private StringBuffer buffer;
	
	private MessageBuilder() {
		buffer = new StringBuffer();
	}
	
	private MessageBuilder(StringBuffer buffer) {
		this.buffer = buffer;
	}
	
	public static MessageBuilder builder() {
		return new MessageBuilder();
	}
	
	public MessageBuilder text(String text) {
		buffer.append(text);
		return this;
	}
	
	public MessageBuilder reset() {
		if (MessageCodes.RESET.equals(last))
			return this;
		buffer.append(MessageCodes.RESET);
		last = MessageCodes.RESET;
		return this;
	}
		
	public String build() {
		return buffer.toString();
	}
	
	public TextBuilder darkRed() {
		buffer.append(MessageCodes.DARK_RED);
		return new TextBuilder();
	}
	
	public TextBuilder red() {
		buffer.append(MessageCodes.RED);
		return new TextBuilder();
	}
	
	public TextBuilder gold() {
		buffer.append(MessageCodes.GOLD);
		return new TextBuilder();
	}
	
	public TextBuilder yellow() {
		buffer.append(MessageCodes.YELLOW);
		return new TextBuilder();
	}
	
	public TextBuilder darkGreen() {
		buffer.append(MessageCodes.DARK_GREEN);
		return new TextBuilder();
	}
	
	public TextBuilder green() {
		buffer.append(MessageCodes.GREEN);
		return new TextBuilder();
	}
	
	public TextBuilder aqua() {
		buffer.append(MessageCodes.AQUA);
		return new TextBuilder();
	}
	
	public TextBuilder darkAqua() {
		buffer.append(MessageCodes.DARK_AQUA);
		return new TextBuilder();
	}
	
	public TextBuilder darkBlue() {
		buffer.append(MessageCodes.DARK_BLUE);
		return new TextBuilder();
	}
	
	public TextBuilder blue() {
		buffer.append(MessageCodes.BLUE);
		return new TextBuilder();
	}
	
	public TextBuilder lightPurple() {
		buffer.append(MessageCodes.LIGHT_PURPLE);
		return new TextBuilder();
	}
	
	public TextBuilder white() {
		buffer.append(MessageCodes.WHITE);
		return new TextBuilder();
	}
	
	public TextBuilder gray() {
		buffer.append(MessageCodes.GRAY);
		return new TextBuilder();
	}
	
	public TextBuilder darkGray() {
		buffer.append(MessageCodes.DARK_GRAY);
		return new TextBuilder();
	}
	
	public TextBuilder black() {
		buffer.append(MessageCodes.BLACK);
		return new TextBuilder();
	}
	
	public class TextBuilder {
	
		private String last;
		
		private TextBuilder() {
			last = null;
		}
		
		private void updateLast(String last) {
			this.last = last;
		}
		
		private void append(String str) {
			buffer.append(str);
			updateLast(str);
		}
		
		public TextBuilder magic() {
			if (MessageCodes.MAGIC.equals(last))
				return this;
			
			append(MessageCodes.MAGIC);
			return this;
		}
		
		public TextBuilder bold() {
			if (MessageCodes.BOLD.equals(last))
				return this;
			
			append(MessageCodes.BOLD);
			return this;
		}
		
		public TextBuilder strikeThrough() {
			append(MessageCodes.STRIKE_THROUGH);
			return this;
		}
		
		public TextBuilder underline() {
			if (MessageCodes.UNDERLINE.equals(last))
				return this;
			
			append(MessageCodes.UNDERLINE);
			return this;
		}
		
		public TextBuilder italic() {
			if (MessageCodes.ITALIC.equals(last))
				return this;
			
			append(MessageCodes.ITALIC);
			return this;
		}
		
		public TextBuilder reset() {
			if (MessageCodes.RESET.equals(last))
				return this;
			
			append(MessageCodes.RESET);
			return this;
		}
		
		public MessageBuilder text(String text) {
			append(text);
			return new MessageBuilder(buffer);
		}
		
		public String build() {
			return buffer.toString();
		}
		
	}
	
	
}
