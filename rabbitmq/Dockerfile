FROM rabbitmq:management
ENV RABBITMQ_USER user
ENV RABBITMQ_PASSWORD prueba01
ENV RABBITMQ_LOGS /var/log/rabbitmq/rabbit.log

ADD init.sh /init.sh
RUN chmod +x init.sh

EXPOSE 15672

CMD ["/init.sh"]
