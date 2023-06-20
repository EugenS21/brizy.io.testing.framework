package org.eugens21.brizy.io.web.interactions.enums;

import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.eugens21.brizy.io.web.interactions.dto.workspace.ElementPositionDto;
import org.eugens21.brizy.io.web.interactions.dto.workspace.ElementSizeDto;

@AllArgsConstructor
@Getter
public enum ElementPositions {

    UNDEFINED {
        @Override
        public ElementPositionDto getPosition(ElementSizeDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x((size.getWidth() / 2) + position.getX())
                    .y((size.getHeight() / 2) + position.getY())
                    .build();
        }
    },
    UP {
        @Override
        public ElementPositionDto getPosition(ElementSizeDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x((size.getWidth() / 2) + position.getX())
                    .y(position.getY())
                    .build();
        }
    },
    BOTTOM {
        @Override
        public ElementPositionDto getPosition(ElementSizeDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x(((size.getWidth() / 2) + position.getX()))
                    .y(size.getHeight() + position.getY())
                    .build();
        }
    },
    RIGHT {
        @Override
        public ElementPositionDto getPosition(ElementSizeDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x(size.getWidth() + position.getX())
                    .y((size.getHeight() / 2) + position.getY())
                    .build();
        }
    },
    LEFT {
        @Override
        public ElementPositionDto getPosition(ElementSizeDto size, ElementPositionDto position) {
            return ElementPositionDto.builder()
                    .x(position.getX())
                    .y((size.getHeight() / 2) + position.getY())
                    .build();
        }
    };

    public abstract ElementPositionDto getPosition(ElementSizeDto size, ElementPositionDto position);

    public static ElementPositions findForString(String value) {
        return Try.of(() -> ElementPositions.valueOf(value))
                .getOrElse(UNDEFINED);
    }

}
