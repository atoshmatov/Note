package uz.gita.noteAppMobDev.domain.usecase

import kotlinx.coroutines.flow.Flow
import uz.gita.noteAppMobDev.data.common.models.NoteData

interface UpdateNoteUseCase {
    fun update(noteData: NoteData): Flow<Result<Unit>>

}