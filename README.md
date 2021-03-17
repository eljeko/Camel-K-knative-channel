# Channel communication with Camel K

This is a simple example to show how to send and consume messages on a knative channel using Camel K services.

# Craete the Knative Channel

The routes don't work if the channel is not present in the namespace

`oc create channel.yaml`

# Run the integration Receiver

`kamel run --name receiverk ReceiverK.java --open-api openapi.yaml --trait openapi.enabled=true`

`URL=$(oc get routes.serving.knative.dev receiverk -o jsonpath='{.status.url}')`

Check the status of the integration

`curl -i $URL/`

Send a message on the channel:

`curl -i $URL/receiver/aMessage`

# Run the knative logger

`kamel run --name loggerk LoggerK.java --trait openapi.enabled=true`








