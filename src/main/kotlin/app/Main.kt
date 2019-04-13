package app

import app.commands.*
import app.commands.Doge.AddDoge
import app.commands.Doge.ListDoge
import app.commands.Doge.RandomDoge
import app.commands.Trash.HKCommand
import app.commands.Trash.HKCommand2
import app.commands.Trash.Wapoosh2
import app.commands.Trash.Whenisay
import app.commands.Vote.Vote
import app.commands.WhackyNumbers.*
import org.javacord.api.DiscordApiBuilder
import java.io.File

fun main() {
    val api = DiscordApiBuilder().setToken(Keys.discord).login().join()

    val cBot = CommunistBot(api)
    cBot.addProccess(Filter())
    cBot.addProccess(Dad())

    cBot.addProccess(Ugly())
    cBot.addProccess(BiggestLove())
    cBot.addProccess(Broadcast(api))
    cBot.addProccess(Love())
    cBot.addProccess(RussianRoulette())
    cBot.addProccess(Pickle())
    cBot.addProccess(Slay())
    cBot.addProccess(Wapoosh2())
    cBot.addProccess(Wapoosh())
    cBot.addProccess(Isanyonethere())
    cBot.addProccess(Whenisay(cBot))
    cBot.addProccess(RoleInfo())
    cBot.addProccess(RandomDoge())
    cBot.addProccess(Speak())
    cBot.addProccess(Devil())
    cBot.addProccess(Angel())
    cBot.addProccess(Alignment())
    cBot.addProccess(HKCommand())
    cBot.addProccess(HKCommand2())
    cBot.addProccess(Avatar())
    cBot.addProccess(Emote())
    cBot.addProccess(ImageToTxt())

    val dogeProcess = AddDoge()
    api.addReactionAddListener(dogeProcess::receiveVoteReaction)
    cBot.addProccess(dogeProcess)
    cBot.addProccess(ListDoge())

    val voteProcess = Vote()
    api.addReactionAddListener(voteProcess::receiveVoteReaction)
    cBot.addProccess(voteProcess)

    api.addMessageCreateListener(cBot::receiveMessage)
    api.addUserRoleAddListener(cBot::mikeyRoleHack)

    api.addServerMemberLeaveListener(cBot::userLeaving)
    api.addServerMemberJoinListener(cBot::userJoining)

    println("---------- BOT ONLINE ----------")

    cBot.gatherRoles()

    /*var file = File("path.txt")
    file.createNewFile()

    api.getChannelById(547303725706903552).get().asTextChannel().get().getMessages(999999999).join().forEach { s ->
        if (!s.content.isBlank())
            file.appendText(s.content + "\n")
    }*/
}