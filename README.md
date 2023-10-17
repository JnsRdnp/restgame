# Blackjack style game made for training Java Spring Boot REST
    "/": "Endpoint info for this Blackjack style game",
    "/setbalance": "Set your balance POST /setbalance?balance=x",
    "/setBetsize": "Set your betsize POST /setbetsize?bet=x",
    "/hit": "Deal a card for the player and returns Game object JSON GET",
    "/stay": "Player stay on number and deal for dealer GET",
    "/values": "Current Game values, OPTIONAL(param=balance/betsize) GET",
    "/save": "Save current game object to a file GET",
    "/getsaved": "Get saved Game object from a file and overwrite current Game object GET"